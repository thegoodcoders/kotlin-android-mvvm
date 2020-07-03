package es.thegoodcode.themoviedb.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.thegoodcode.themoviedb.common.Resource
import es.thegoodcode.themoviedb.repository.TheMovieDBRepository
import es.thegoodcode.themoviedb.response.PopularMoviesResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class MoviesViewModel: ViewModel() {
    private var theMovieDBRepository: TheMovieDBRepository = TheMovieDBRepository()
    var popularMovies: MutableLiveData<Resource<PopularMoviesResponse>> = MutableLiveData()

    init {
        getPopularesMovies()
    }

    fun getPopularesMovies() = viewModelScope.launch {
        popularMovies.value = Resource.Loading()

        val response = theMovieDBRepository.getPopularMovies()
        popularMovies.value = handlePopularMoviesResponse(response)
    }

    private fun handlePopularMoviesResponse(response: Response<PopularMoviesResponse>): Resource<PopularMoviesResponse>? {
        if(response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }

        return Resource.Error("Error en popular movies")
    }
}