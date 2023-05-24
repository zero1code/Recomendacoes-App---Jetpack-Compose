package com.example.recomendacoes.data.local

import com.example.recomendacoes.R
import com.example.recomendacoes.model.Categoria
import com.example.recomendacoes.model.Recomendacao

object LocalDataProvider {
    val allCinemas = listOf(
        Recomendacao(
            nome = "Cinemark - Shopping Eldorado",
            endereco = "Av. Rebouças, 3970 - Pinheiros, São Paulo - SP",
            site = "https://www.cinemark.com.br",
            imagemLocal = R.drawable.cinema_eldorado
        ),
        Recomendacao(
            nome = "Kinoplex - Shopping Vila Olímpia",
            endereco = "R. Olimpíadas, 360 - Vila Olímpia, São Paulo - SP",
            site = "https://www.kinoplex.com.br",
            imagemLocal = R.drawable.cinema_vila_olimpia
        ),
        Recomendacao(
            nome = "PlayArte - Shopping Pátio Paulista",
            endereco = "R. Treze de Maio, 1947 - Bela Vista, São Paulo - SP",
            site = "https://www.playarte.com.br",
            imagemLocal = R.drawable.cinema_patio_paulista
        ),
        Recomendacao(
            nome = "UCI Cinemas - Jardim Sul",
            endereco = "Av. Giovanni Gronchi, 5819 - Vila Andrade, São Paulo - SP",
            site = "https://www.ucicinemas.com.br",
            imagemLocal = R.drawable.cinema_jardim_sul
        ),
        Recomendacao(
            nome = "Espaço Itaú de Cinema - Augusta",
            endereco = "R. Augusta, 1470 - Consolação, São Paulo - SP",
            site = "https://www.itaucinemas.com.br",
            imagemLocal = R.drawable.cinema_itau
        ),
    )

    val allRestaurantes = listOf(
        Recomendacao(
            nome = "D.O.M.",
            endereco = "R. Barão de Capanema, 549 - Jardins, São Paulo - SP",
            site = "https://www.domrestaurante.com.br",
            tipoCozinha = "Brasileira contemporânea",
            imagemLocal = R.drawable.restaurante_dom
        ),
        Recomendacao(
            nome = "Fasano",
            endereco = "R. Vitório Fasano, 88 - Cerqueira César, São Paulo - SP",
            site = "https://www.fasano.com.br/restaurantes/restaurante-fasano",
            tipoCozinha = "Italiana",
            imagemLocal = R.drawable.restaurante_fasano
        ),
        Recomendacao(
            nome = "Mocotó",
            endereco = "Av. Nossa Sra. do Loreto, 1100 - Vila Medeiros, São Paulo - SP",
            site = "http://www.mocoto.com.br",
            tipoCozinha = "Nordestina",
            imagemLocal = R.drawable.restaurante_mocoto
        ),
        Recomendacao(
            nome = "Maní",
            endereco = "R. Joaquim Antunes, 210 - Jardim Paulistano, São Paulo - SP",
            site = "https://www.manimanioca.com.br",
            tipoCozinha = "Contemporânea",
            imagemLocal = R.drawable.restaurante_mani
        ),
        Recomendacao(
            nome = "A Figueira Rubaiyat",
            endereco = "R. Haddock Lobo, 1738 - Cerqueira César, São Paulo - SP",
            site = "https://www.rubaiyat.com.br/figueira",
            tipoCozinha = "Churrascaria e contemporânea",
            imagemLocal = R.drawable.restaurante_figueira_rubaiyat
        ),
    )

    val allShoppings = listOf(
        Recomendacao(
            nome = "Shopping Ibirapuera",
            endereco = "Av. Ibirapuera, 3103 - Moema, São Paulo - SP",
            site = "https://www.ibirapuera.com.br",
            imagemLocal = R.drawable.shopping_ibirapuera
        ),
        Recomendacao(
            nome = "Shopping Morumbi",
            endereco = "Av. Roque Petroni Júnior, 1089 - Morumbi, São Paulo - SP",
            site = "https://www.shoppingmorumbi.com.br",
            imagemLocal = R.drawable.shopping_morumbi
        ),
        Recomendacao(
            nome = "Shopping Eldorado",
            endereco = "Av. Rebouças, 3970 - Pinheiros, São Paulo - SP",
            site = "https://www.shoppingeldorado.com.br",
            imagemLocal = R.drawable.shopping_eldorado
        ),
        Recomendacao(
            nome = "Shopping Center 3",
            endereco = "Av. Paulista, 2064 - Cerqueira César, São Paulo - SP",
            site = "https://www.shoppingcenter3.com.br",
            imagemLocal = R.drawable.shopping_center_3
        ),
        Recomendacao(
            nome = "Shopping Pátio Paulista",
            endereco = "R. Treze de Maio, 1947 - Bela Vista, São Paulo - SP",
            site = "https://www.shoppingpatiopaulista.com.br",
            imagemLocal = R.drawable.shopping_patio_paulista
        ),
    )

    val allParques = listOf(
        Recomendacao(
            nome = "Parque Ibirapuera",
            endereco = "Av. Pedro Álvares Cabral, s/n - Vila Mariana, São Paulo - SP",
            imagemLocal = R.drawable.parque_ibirapuera
        ),
        Recomendacao(
            nome = "Parque Villa-Lobos",
            endereco = "Av. Prof. Fonseca Rodrigues, 2001 - Alto de Pinheiros, São Paulo - SP",
            imagemLocal = R.drawable.parque_villa_lobos
        ),
        Recomendacao(
            nome = "Parque da Aclimação",
            endereco = "R. Muniz de Sousa, 1119 - Aclimação, São Paulo - SP",
            imagemLocal = R.drawable.parque_da_aclimacao
        ),
        Recomendacao(
            nome = "Parque do Carmo",
            endereco = "Av. Afonso de Sampaio e Sousa, 951 - Itaquera, São Paulo - SP",
            imagemLocal = R.drawable.parque_do_carmo
        ),
        Recomendacao(
            nome = "Parque Burle Marx",
            endereco = "Av. Dona Helena Pereira de Moraes, 200 - Vila Andrade, São Paulo - SP",
            imagemLocal = R.drawable.parque_burle_marx
        ),
    )

    val allMuseus = listOf(
        Recomendacao(
            nome = "Museu de Arte de São Paulo (MASP)",
            endereco = "Av. Paulista, 1578 - Bela Vista, São Paulo - SP",
            imagemLocal = R.drawable.museu_masp
        ),
        Recomendacao(
            nome = "Museu de Arte Moderna de São Paulo (MAM)",
            endereco = "Parque Ibirapuera, Portão 3 - Av. Pedro Álvares Cabral, s/n - Vila Mariana, São Paulo - SP",
            imagemLocal = R.drawable.museu_mam
        ),
        Recomendacao(
            nome = "Museu da Imagem e do Som de São Paulo (MIS)",
            endereco = "Av. Europa, 158 - Jardim Europa, São Paulo - SP",
            imagemLocal = R.drawable.museu_mis
        ),
        Recomendacao(
            nome = "Museu Afro Brasil",
            endereco = "Parque Ibirapuera, Portão 10 - Av. Pedro Álvares Cabral, s/n - Vila Mariana, São Paulo - SP",
            imagemLocal = R.drawable.museu_afro_brasil
        ),
        Recomendacao(
            nome = "Pinacoteca do Estado de São Paulo",
            endereco = "Praça da Luz, 2 - Luz, São Paulo - SP",
            imagemLocal = R.drawable.museu_pinacoteca
        ),
    )

    val allCategorias = mapOf(
        "Cinemas" to allCinemas,
        "Restaurantes" to allRestaurantes,
        "Shoppings" to allShoppings,
        "Parques" to allParques,
        "Museus" to allMuseus
    )

    val defaultCategoria = Categoria(
        nomeCategoria = "Default",
        imagemCategoria = R.drawable.ic_launcher_background,
    )

    val defaultRecomendacao = allCinemas.random()
}