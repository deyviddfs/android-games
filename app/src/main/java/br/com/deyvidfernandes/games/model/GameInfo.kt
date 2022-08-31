package br.com.deyvidfernandes.games.model

import com.squareup.moshi.Json

data class GameInfo(
    val id: String,
    @Json(name = "title") val title: String,
    @Json(name = "thumbnail") val pathImg: String,
    @Json(name = "short_description") val shorDescription: String,
    @Json(name = "description") val description: String,
    @Json(name = "platform") val platform: String,
    @Json(name = "developer") val developer: String,
    @Json(name = "release_date") val releaseDate: String
)
