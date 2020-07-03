package es.thegoodcode.themoviedb.api

import es.thegoodcode.themoviedb.common.Constantes
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkContainer {

    private val theMovieDBInterceptor = TheMovieDBInterceptor()

    val theMovieDBService: TheMovieDBService = Retrofit.Builder()
        .baseUrl(Constantes.API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TheMovieDBService::class.java)
}