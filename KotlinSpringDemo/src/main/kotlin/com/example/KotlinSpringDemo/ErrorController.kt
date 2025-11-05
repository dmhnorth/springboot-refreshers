package com.example.KotlinSpringDemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


//This is currently unused but could be customised to be a general all purpose error handler
@RestController
class ErrorController {
    @GetMapping("/error")
    fun error() = "An Error Occurred! This is an explicit warning via code."
}