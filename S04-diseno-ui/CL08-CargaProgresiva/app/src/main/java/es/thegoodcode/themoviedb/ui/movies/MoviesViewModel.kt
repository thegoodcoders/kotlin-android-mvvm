package es.thegoodcode.themoviedb.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.thegoodcode.themoviedb.repository.TheMovieDBRepository
import es.thegoodcode.themoviedb.response.PopularMoviesResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class MoviesViewModel: ViewModel() {
    private var theMovieDBRepository: TheMovieDBRepository = TheMovieDBRepository()
    var popularMovies: MutableLiveData<Response<PopularMoviesResponse>> = MutableLiveData()

    init {
        getPopularesMovies()
    }

    fun getPopularesMovies() = viewModelScope.launch {
        popularMovies.value = theMovieDBRepository.getPopularMovies()
    }
}