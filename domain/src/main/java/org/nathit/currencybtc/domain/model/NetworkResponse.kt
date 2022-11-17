package org.nathit.currencybtc.domain.model

import java.io.IOException

sealed class NetworkResponse<out T : Any, out U : Any> {
    /**
     * Success response with body
     */
    data class Success<T : Any>(val body: T) : NetworkResponse<T, Nothing>()

    /**
     * Failure response with body
     */
    data class ApiError<U : Any>(val body: U, val code: String) : NetworkResponse<Nothing, U>()

    /**
     * Network error
     */
    data class NetworkError(val error: IOException) : NetworkResponse<Nothing, Nothing>()

    /**
     * For example, json parsing error
     */
    data class UnknownError(val error: Throwable?) : NetworkResponse<Nothing, Nothing>()
}

inline fun <T : Any, U : Any, R : Any> NetworkResponse<T, U>.mapOnSuccess(map: (T) -> R): NetworkResponse<R, U> =
    when (this) {
        is NetworkResponse.Success -> NetworkResponse.Success(map(body))
        is NetworkResponse.ApiError -> this
        is NetworkResponse.NetworkError -> this
        is NetworkResponse.UnknownError -> this
    }

fun <T : Any, U : Any> NetworkResponse<T, U>.getSuccessOrNull(): T? =
    when (this) {
        is NetworkResponse.Success -> this.body
        else -> null
    }