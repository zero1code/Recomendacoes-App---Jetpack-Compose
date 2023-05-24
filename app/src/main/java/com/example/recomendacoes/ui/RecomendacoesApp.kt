package com.example.recomendacoes.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.recomendacoes.R


enum class RecomendacoesTela(@StringRes val titulo: Int) {
    Home(titulo = R.string.minha_cidade),
    Recomendacoes(titulo = R.string.recomendacoes),
    Detalhes(titulo = R.string.detalhes_local),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopbar(
    modifier: Modifier = Modifier,
    telaAtual: RecomendacoesTela,
    podeNavegarDeVolta: Boolean,
    navegarDeVolta: () -> Unit
) {
    CenterAlignedTopAppBar(
        modifier = modifier
            .fillMaxWidth(),
        title = {
            Text(
                text = stringResource(id = telaAtual.titulo),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            if (podeNavegarDeVolta) {
                IconButton(onClick = navegarDeVolta) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.button_voltar),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecomendacoesApp(
    modifier: Modifier = Modifier,
    viewModel: RecomendacoesViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val pilhaDeTela by navController.currentBackStackEntryAsState()
    val telaAtual = RecomendacoesTela.valueOf(
        pilhaDeTela?.destination?.route ?: RecomendacoesTela.Home.name
    )

    Scaffold(
        topBar = {
            HomeScreenTopbar(
                telaAtual = telaAtual,
                podeNavegarDeVolta = navController.previousBackStackEntry != null,
                navegarDeVolta = { navController.navigateUp() }
            )
        },
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        val uiState = viewModel.uiState.collectAsState().value

        NavHost(
            modifier = modifier.padding(it),
            navController = navController,
            startDestination = RecomendacoesTela.Home.name,
        ) {

            composable(route = RecomendacoesTela.Home.name) {
                HomeScreen(
                    uiState = uiState,
                    onCategoriaCardPressed = { categoria ->
                        viewModel.updateCategoriaSelecionada(categoria = categoria)
                        navController.navigate(RecomendacoesTela.Recomendacoes.name)
                    }
                )
            }

            composable(route = RecomendacoesTela.Recomendacoes.name) {
                RecomendacoesScreen(
                    uiState = uiState,
                    onRecomendacaoCardPressed = { recomendacao ->
                        viewModel.updateRecomendacaoSelecionada(recomendacao)
                        navController.navigate(RecomendacoesTela.Detalhes.name)
                    } )
            }
            
            composable(route = RecomendacoesTela.Detalhes.name) {
                val uriHandler = LocalUriHandler.current
                val context = LocalContext.current
                DetalhesScreen(
                    uiState = uiState,
                    onTopicoCardPressed = { topico ->
                        if (topico.contains("http")) {
                           openWebSite(uriHandler, topico)
                        } else {
                            openMap(context, topico)
                        }
                    }
                )
            }
        }
    }
}

private fun openWebSite(uriHandler: UriHandler, site: String) {
    uriHandler.openUri(site)
}

private fun openMap(context: Context, endereco: String) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse("http://maps.google.co.in/maps?q=$endereco")
    context.startActivity(intent)

}