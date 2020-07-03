package es.thegoodcode.themoviedb.api.response

data class APIError(
    val status_code: Int,
    val status_message: String,
    val success: Boolean
)