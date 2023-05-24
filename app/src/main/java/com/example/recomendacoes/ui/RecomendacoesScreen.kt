package com.example.recomendacoes.ui

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recomendacoes.R
import com.example.recomendacoes.model.Recomendacao
import com.example.recomendacoes.ui.theme.RecomendacoesTheme

@Composable
fun RecomendacoesScreen(
    modifier: Modifier = Modifier,
    uiState: RecomendacoesUiState,
    onRecomendacaoCardPressed: (Recomendacao) -> Unit
) {
    ListaRecomendacao(
        modifier = modifier,
        uiState = uiState,
        onRecomendacaoCardPressed = onRecomendacaoCardPressed
    )
}

@Composable
fun ListaRecomendacao(
    modifier: Modifier = Modifier,
    uiState: RecomendacoesUiState,
    onRecomendacaoCardPressed: (Recomendacao) -> Unit
) {
    val listaRecomendacao = uiState.listaRecomendacao

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medio)),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_medio))
    ) {
        item {
            RecomendacaoCabecalho(
                categoriaSelecionada = uiState.categoriaSelecionada.nomeCategoria.lowercase()
            )
        }
        items(listaRecomendacao, key = { recomendacao -> recomendacao.nome }) { recomendacao ->
            RecomendacaoItem(
                recomendacao = recomendacao,
                onCardClick = {
                    onRecomendacaoCardPressed(recomendacao)
                }
            )
        }
    }
}

@Composable
fun RecomendacaoCabecalho(
    categoriaSelecionada: String
) {
    Row() {
        Text(
            text = stringResource(id = R.string.recomendacao_cabecalho, categoriaSelecionada),
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecomendacaoItem(
    modifier: Modifier = Modifier,
    recomendacao: Recomendacao,
    onCardClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_pequeno)),
        onClick = onCardClick
    ) {
        Row {
            ImagemRecomendacao(
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.card_size))
                    .aspectRatio(0.8f)
                ,
                imagemRecomendacao = recomendacao.imagemLocal
            )
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(dimensionResource(id = R.dimen.padding_pequeno)),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                NomeEnderecoRecomendacao(
                    recomendacao = recomendacao
                )

                Visualizacoes(
                    modifier = Modifier.align(Alignment.End)
                )
            }

        }
    }
}

@Composable
fun ImagemRecomendacao(
    modifier: Modifier = Modifier,
    @DrawableRes imagemRecomendacao: Int
) {
    Image(
        modifier = modifier
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.padding_pequeno))),
        painter = painterResource(id = imagemRecomendacao),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun NomeEnderecoRecomendacao(
    modifier: Modifier = Modifier,
    recomendacao: Recomendacao
) {
    Column(modifier = modifier) {
        Text(
            text = recomendacao.nome,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.padding_pequeno)))
        Text(
            text = recomendacao.endereco,
            style = MaterialTheme.typography.labelMedium,
            color = Color.Gray
        )
    }
}

@Composable
fun Visualizacoes(
    modifier: Modifier = Modifier
) {
    val quantidade = (1..100).random()
    val color = when (quantidade) {
        in 1..25 -> Color(0xFFFF9900)
        in 26 ..60 -> Color(0xFF34AF61)
        else -> Color(0xFFF34349)
    }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(dimensionResource(id = R.dimen.padding_medio)),
            imageVector = Icons.Filled.Visibility,
            contentDescription = stringResource(id = R.string.button_voltar),
            tint = color
        )
        Text(
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_pequeno)),
            text = "${quantidade}k",
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview
@Composable
fun RecomendacaoItemLightPreview() {
    RecomendacoesTheme {
        Surface {
            RecomendacaoItem(
                recomendacao = Recomendacao(
                    nome = "Museu de Arte de São Paulo (MASP)",
                    imagemLocal = R.drawable.museu_masp,
                    endereco = "Av. Paulista, 1578 - Bela Vista, São Paulo - SP"
                ),
                onCardClick = {}
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RecomendacaoItemDarkPreview() {
    RecomendacoesTheme {
        Surface {
            RecomendacaoItem(
                recomendacao = Recomendacao(
                    nome = "Museu de Arte Moderna de São Paulo (MAM)",
                    imagemLocal = R.drawable.museu_mam,
                    endereco = "Parque Ibirapuera, Portão 3 - Av. Pedro Álvares Cabral, s/n - Vila Mariana, São Paulo - SP"
                ),
                onCardClick = {}
            )
        }
    }
}