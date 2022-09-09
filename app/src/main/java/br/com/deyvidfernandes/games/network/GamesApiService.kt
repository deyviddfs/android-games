package br.com.deyvidfernandes.games.network


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val URL = "https://www.freetogame.com/api/"

private val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()

private val retrofit = Retrofit.Builder()
                        .addConverterFactory(MoshiConverterFactory.create(moshi))
                        .baseUrl(URL)
                        .build()

interface GamesApiService {
    @GET("games")
    suspend fun getGames(): List<Game>

    @GET("game")
    suspend fun getGame(@Query("id") id: String) : GameInfo
}

object GameApi{
    val RETROFIT_SERVICE: GamesApiService by lazy {
        retrofit.create(GamesApiService::class.java)
    }
}