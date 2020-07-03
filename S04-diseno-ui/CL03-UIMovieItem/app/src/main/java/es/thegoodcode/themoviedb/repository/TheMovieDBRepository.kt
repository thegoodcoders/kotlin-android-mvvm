package es.thegoodcode.themoviedb.repository

import es.thegoodcode.themoviedb.common.MyApp

class TheMovieDBRepository {
    private val theMovieDBService = MyApp.networkContainer.theMovieDBService

    suspend fun getPopularMovies() = theMovieDBService.getPopularMovies()
}