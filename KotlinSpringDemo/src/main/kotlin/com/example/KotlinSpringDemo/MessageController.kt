package com.example.KotlinSpringDemo

import com.example.KotlinSpringDemo.domain.Message
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/")
class MessageController(private val service: MessageService) {
    @GetMapping
    fun listMessages() = service.findMessages()

    @PostMapping
    fun post(@RequestBody message: Message): ResponseEntity<Message> {
        val savedMessage = service.save(message)
        return ResponseEntity.created(URI("/${savedMessage.id}")).body(savedMessage)
    }

    @GetMapping("/indexInfo")
    fun index(@RequestParam("name") name: String = "Anonymous") = "Hello, $name! \ncheck out http://localhost:8080/actuator/mappings"


    @GetMapping("/genericMessagesList")
    fun listImmutableMessages() = listOf(
        Message("1", "Hello!"),
        Message("2", "Bonjour!"),
        Message("3", "Privet!"), //The comma here is called a trailing comma and is optional
    )

    //These functions return JSON responses as default due to the transitive inheritance of Jackson via Spring boot
}
