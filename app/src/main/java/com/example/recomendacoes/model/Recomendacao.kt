package com.example.recomendacoes.model

import androidx.annotation.DrawableRes

data class Recomendacao(
    val nome: String = "",
    val endereco: String = "",
    val site: String = "",
    val tipoCozinha: String = "",
    @DrawableRes val imagemLocal: Int
)
