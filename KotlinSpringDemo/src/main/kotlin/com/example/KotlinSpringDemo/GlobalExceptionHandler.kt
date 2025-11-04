package com.example.KotlinSpringDemo

import org.springframework.data.mapping.MappingException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.NoHandlerFoundException

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException::class)
    fun handleMappingException(ex: NoHandlerFoundException): ResponseEntity<String> {
        return ResponseEntity(ex.message + "Hey fix me", HttpStatus.BAD_REQUEST)
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TodoNotFoundException::class)
    fun handleTodoNotFoundException(ex: TodoNotFoundException): ResponseEntity<String> {
        return ResponseEntity(ex.message + "Or you could fix this?", HttpStatus.NOT_FOUND)
    }
}

//Working out https://codesignal.com/learn/courses/advanced-restful-techniques/lessons/error-handling-in-spring-boot-with-kotlin

