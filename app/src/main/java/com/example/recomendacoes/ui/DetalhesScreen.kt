package com.example.recomendacoes.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.example.recomendacoes.R
import com.example.recomendacoes.ui.theme.RecomendacoesTheme
import com.example.recomendacoes.ui.utils.RecomendacoesTipoConteudo

@Composable
fun DetalhesScreen(
    modifier: Modifier = Modifier,
    tipoConteudo: RecomendacoesTipoConteudo = RecomendacoesTipoConteudo.SOMENTE_LISTA,
    uiState: RecomendacoesUiState,
    onTopicoCardPressed: (String) -> Unit
) {
    val recomendacao = uiState.recomendacaoSelecionada
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ImagemNomeLocal(
            tipoConteudo = tipoConteudo,
            imagemLocal = recomendacao.imagemLocal,
            nomeLocal = recomendacao.nome
        )

        if (recomendacao.tipoCozinha.isNotBlank()) {
            InformacaoLocal(
                topico = "Tipo de cozinha",
                valor = recomendacao.tipoCozinha,
                icone = Icons.Filled.Restaurant,
                onCardClick = { onTopicoCardPressed(it) }
            )
        }
        InformacaoLocal(
            topico = "Endereço",
            valor = recomendacao.endereco,
            icone = Icons.Filled.OpenInNew,
            onCardClick = { onTopicoCardPressed(it) }
        )
        if (recomendacao.site.isNotBlank()) {
            InformacaoLocal(
                topico = "Site",
                valor = recomendacao.site,
                icone = Icons.Filled.OpenInNew,
                onCardClick = { onTopicoCardPressed(it) }
            )
        }
        DescricaoLocal()
    }

}

@Composable
fun ImagemNomeLocal(
    modifier: Modifier = Modifier,
    tipoConteudo: RecomendacoesTipoConteudo,
    @DrawableRes imagemLocal: Int,
    nomeLocal: String
) {
    val padding = if (tipoConteudo == RecomendacoesTipoConteudo.SOMENTE_LISTA) 0.dp
        else dimensionResource(id = R.dimen.padding_pequeno)
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color(0xE6000000)),
        startY = 300f,
        endY = 500f
    )
    Box(modifier = modifier
        .height(dimensionResource(id = R.dimen.imagem_local_size))
    ) {

        Image(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = padding)
                .clip(RoundedCornerShape(padding)),
            painter = painterResource(id = imagemLocal),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    drawRect(
                        brush = gradient,
                        size = size
                    )
                }
        )
        val textPadding =
            if (tipoConteudo == RecomendacoesTipoConteudo.SOMENTE_LISTA)
                dimensionResource(id = R.dimen.padding_pequeno)
            else dimensionResource(id = R.dimen.padding_medio)
        Text(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(textPadding),
            text = nomeLocal,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InformacaoLocal(
    modifier: Modifier = Modifier,
    topico: String,
    valor: String,
    icone: ImageVector,
    onCardClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_pequeno)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_pequeno))
    ) {
        Text(text = topico,)
        Card(
            modifier = modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_pequeno)),
            onClick = { onCardClick(valor) }
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = dimensionResource(id = R.dimen.padding_pequeno),
                    vertical = dimensionResource(id = R.dimen.padding_medio)
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = valor,
                    style = MaterialTheme.typography.bodyMedium
                )
                Icon(
                    modifier = Modifier
                        .padding(start = dimensionResource(id = R.dimen.padding_pequeno)),
                    imageVector = icone,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }

}

@Composable
fun DescricaoLocal(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_pequeno)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_pequeno))
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.sobre_o_local),

        )
        Card(
            modifier = modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_pequeno)),
        ) {
            Text(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_pequeno)),
                text = LoremIpsum(200).values.first(),
                style = MaterialTheme.typography.bodyMedium
            )

        }
    }
}

@Preview(showSystemUi = false, widthDp = 1000)
@Composable
fun DetalhesScreenPreview() {
    RecomendacoesTheme {
        Surface {
            Column() {
                ImagemNomeLocal(
                    tipoConteudo = RecomendacoesTipoConteudo.LISTA_E_DETALHES,
                    imagemLocal = R.drawable.cinema_eldorado,
                    nomeLocal = "Nome Local"
                )
            }
        }
    }
}