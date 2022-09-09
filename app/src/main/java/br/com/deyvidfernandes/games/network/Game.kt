package br.com.deyvidfernandes.games.network

import com.squareup.moshi.Json

data class Game (
            val id: String,
            @Json(name = "title") val title: String,
            @Json(name = "thumbnail") val pathImg: String
        )