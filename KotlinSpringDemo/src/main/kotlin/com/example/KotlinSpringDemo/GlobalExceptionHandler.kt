package com.example.KotlinSpringDemo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.NoHandlerFoundException

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException::class)
    fun handleNoHandlerFound(ex: NoHandlerFoundException): ResponseEntity<String> {
        return ResponseEntity("404 Not Found: ${ex.requestURL} Raw Message: " + ex.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(TodoNotFoundException::class)
    fun handleTodoNotFound(ex: TodoNotFoundException): ResponseEntity<String> {
        return ResponseEntity("Todo not found: ${ex.message}", HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ResponseEntity<String> {
        return ResponseEntity("Internal Server Error: ${ex.message}", HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
