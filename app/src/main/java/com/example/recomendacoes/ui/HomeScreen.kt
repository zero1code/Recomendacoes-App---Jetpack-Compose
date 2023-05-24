package com.example.recomendacoes.ui

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.recomendacoes.R
import com.example.recomendacoes.model.Categoria
import com.example.recomendacoes.ui.theme.RecomendacoesTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: RecomendacoesUiState,
    onCategoriaCardPressed: (Categoria) -> Unit
) {
    ListaCategoria(
        modifier = modifier,
        uiState = uiState,
        onCategoriaCardPressed = onCategoriaCardPressed
    )
}

@Composable
fun ListaCategoria(
    modifier: Modifier = Modifier,
    uiState: RecomendacoesUiState,
    onCategoriaCardPressed: (Categoria) -> Unit
) {
    val listaCategoria = uiState.listaCategoria

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medio)),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_medio))
    ) {
        items(listaCategoria, key = { categoria -> categoria.nomeCategoria }) { categoria ->
            CategoriaItem(
                categoria = categoria,
                onCardClick = {
                    onCategoriaCardPressed(categoria)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriaItem(
    modifier: Modifier = Modifier,
    categoria: Categoria,
    onCardClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .sizeIn(
                minWidth = dimensionResource(id = R.dimen.card_size),
                maxHeight = dimensionResource(id = R.dimen.card_max_size)
            ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_pequeno)),
        onClick = onCardClick
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            ImagemCategoria(
                modifier = Modifier.align(Alignment.CenterEnd),
                categoria.imagemCategoria
            )
            TituloDescricaoCategoria(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_pequeno)),
                nomeCategoria = categoria.nomeCategoria
            )
        }
    }

}

@Composable
fun ImagemCategoria(
    modifier: Modifier = Modifier,
    @DrawableRes imagemCategoria: Int
) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(MaterialTheme.colorScheme.background, Color.Transparent),
        startX = 600f,
        endX = 900f
    )
    Box(modifier = modifier) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = imagemCategoria),
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
    }
}

@Composable
fun TituloDescricaoCategoria(
    modifier: Modifier = Modifier,
    nomeCategoria: String
) {
    Column(
        modifier = modifier

    ) {
        Text(
            text = nomeCategoria,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medio)))
        Text(
            modifier = Modifier
                .padding(end = dimensionResource(id = R.dimen.card_size)),
            text = LoremIpsum((10..20).random()).values.first(),
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun CategoriaItemLightPreview() {
    RecomendacoesTheme {
        Surface {
            CategoriaItem(
                categoria = Categoria(
                    "Restaurantes",
                    R.drawable.restaurante_mani
                ),
                onCardClick = {}
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CategoriaItemDarkPreview() {
    RecomendacoesTheme {
        Surface {
            CategoriaItem(
                categoria = Categoria(
                "Restaurantes",
                    R.drawable.restaurante_mani
                ),
                onCardClick = {}
            )
        }
    }
}