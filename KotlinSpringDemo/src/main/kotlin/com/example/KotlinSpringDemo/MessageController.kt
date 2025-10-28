package com.example.KotlinSpringDemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController {
    @GetMapping("/hello")
    fun index(@RequestParam("name") name: String = "Anonymous") = "Hello, $name!"

    @GetMapping("/error")
    fun error(): String = "An error occurred!"
}


