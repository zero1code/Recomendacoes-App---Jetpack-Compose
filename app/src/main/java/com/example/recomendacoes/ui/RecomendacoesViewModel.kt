package com.example.recomendacoes.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.recomendacoes.data.local.LocalDataProvider
import com.example.recomendacoes.model.Categoria
import com.example.recomendacoes.model.Recomendacao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecomendacoesViewModel() : ViewModel() {

    private val _uiState = MutableStateFlow(RecomendacoesUiState())
    val uiState get() = _uiState.asStateFlow()

    init {
        inicializarUiState()
    }

    private fun inicializarUiState() {
        val listaCategoria = LocalDataProvider.allCategorias.map { (categoria, listaSugestao) ->
            Categoria(
                nomeCategoria = categoria,
                imagemCategoria = listaSugestao.random().imagemLocal
            )
        }
        _uiState.value =
            RecomendacoesUiState(
                listaCategoria = listaCategoria
            )
    }

    fun updateCategoriaSelecionada(categoria: Categoria) {
        val primeiraRecomendacao = LocalDataProvider.allCategorias[categoria.nomeCategoria]!![0]
        _uiState.update {
            it.copy(
                categoriaSelecionada = categoria,
                recomendacaoSelecionada = primeiraRecomendacao,
                estaMostrandoHomeScreen = false
            )
        }
    }

    fun updateRecomendacaoSelecionada(recomendacao: Recomendacao) {
        _uiState.update {
            it.copy(
                recomendacaoSelecionada = recomendacao,
            )
        }
    }
}