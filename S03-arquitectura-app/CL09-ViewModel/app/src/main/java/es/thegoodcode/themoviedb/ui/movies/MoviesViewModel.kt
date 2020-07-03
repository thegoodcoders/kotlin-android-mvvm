package es.thegoodcode.themoviedb.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.thegoodcode.themoviedb.repository.TheMovieDBRepository
import es.thegoodcode.themoviedb.response.PopularMoviesResponse

class MoviesViewModel: ViewModel() {
    private var theMovieDBRepository: TheMovieDBRepository = TheMovieDBRepository()
    var popularMovies: MutableLiveData<PopularMoviesResponse> = MutableLiveData()


    fun getPopularesMovies() = theMovieDBRepository.getPopularMovies()
}