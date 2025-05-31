package com.pantano.cinePantanoApplication.configuration

import com.pantano.cinePantanoApplication.core.domain.movie.exceptions.MovieNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    class ErrorResponse(
        val message: String
    )

    @ExceptionHandler(MovieNotFoundException::class)
    fun handleMovieNotFoundException(exception: MovieNotFoundException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            message = exception.message ?: "Movie not found"
        )
        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(SecurityException::class)
    fun handleSecurityException(exception: SecurityException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            message = exception.message ?: "Security error"
        )
        return ResponseEntity(errorResponse, HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(exception: IllegalArgumentException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            message = exception.message ?: "Invalid argument"
        )
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }
}
