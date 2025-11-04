package com.example.KotlinSpringDemo

import com.example.KotlinSpringDemo.domain.ImmutableMessage
import com.example.KotlinSpringDemo.domain.MutableMessage
import org.apache.logging.log4j.message.Message
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class MessageController(private val service: MessageService) {
    @GetMapping("/")
    fun index(@RequestParam("name") name: String = "Anonymous") = "Hello, $name! \ncheck out http://localhost:8080/actuator/mappings"

    @GetMapping
    fun listMessages() = service.findImmutableMessages()

    @PostMapping
    fun post(@RequestBody message: ImmutableMessage): ResponseEntity<ImmutableMessage> {
        val savedMessage = service.save(message)
        return ResponseEntity.created(URI("/${savedMessage.id}")).body(savedMessage)
    }


    @GetMapping("/immutableMessagesList")
    fun listImmutableMessages() = listOf(
        ImmutableMessage("1", "Hello!"),
        ImmutableMessage("2", "Bonjour!"),
        ImmutableMessage("3", "Privet!"), //The comma here is called a trailing comma and is optional
    )

    @GetMapping("/mutableMessagesList")
    fun listMutableMessages() = mutableListOf(
        MutableMessage("1", "Hello!"),
        MutableMessage("2", "Bonjour!"),
        MutableMessage("3", "Privet!"),
    )
    //These functions return JSON responses as default due to the transitive inheritance of Jackson via Spring boot
}
