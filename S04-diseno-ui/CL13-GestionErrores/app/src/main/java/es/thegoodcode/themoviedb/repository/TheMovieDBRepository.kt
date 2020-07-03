package es.thegoodcode.themoviedb.repository

import es.thegoodcode.themoviedb.api.response.APIError
import es.thegoodcode.themoviedb.common.MyApp
import org.json.JSONObject
import retrofit2.Response

class TheMovieDBRepository {
    private val theMovieDBService = MyApp.networkContainer.theMovieDBService

    suspend fun getPopularMovies() = theMovieDBService.getPopularMovies()

    fun parseError(response: Response<*>): APIError {
        val jsonObject = JSONObject(response.errorBody()?.string())
        return APIError(
            jsonObject.getInt("status_code"),
            jsonObject.getString("status_message"),
            jsonObject.getBoolean("success")
        )
    }
}