package id.health.mate.data.source.remote.response.helper

import id.health.mate.data.source.remote.response.ErrorResponse

sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val apiError: ErrorResponse?) : ApiResponse<Nothing>()
}