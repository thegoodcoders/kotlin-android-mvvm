package es.thegoodcode.themoviedb.api

import es.thegoodcode.themoviedb.api.response.PopularMoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface TheMovieDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<PopularMoviesResponse>
}