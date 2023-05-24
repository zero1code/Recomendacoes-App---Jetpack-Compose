package com.example.recomendacoes.ui

import com.example.recomendacoes.data.local.LocalDataProvider
import com.example.recomendacoes.model.Categoria
import com.example.recomendacoes.model.Recomendacao

data class RecomendacoesUiState(
    val listaCategoria: List<Categoria> = emptyList(),
    val categoriaSelecionada: Categoria = LocalDataProvider.defaultCategoria,
    val recomendacaoSelecionada: Recomendacao = LocalDataProvider.defaultRecomendacao,
    val estaMostrandoHomeScreen: Boolean = true
) {
    val listaRecomendacao: List<Recomendacao> by lazy { LocalDataProvider.allCategorias[categoriaSelecionada.nomeCategoria]!! }
}
