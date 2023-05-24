package com.example.recomendacoes.model

import androidx.annotation.DrawableRes

data class Categoria(
    val nomeCategoria: String,
    @DrawableRes val imagemCategoria: Int
)
