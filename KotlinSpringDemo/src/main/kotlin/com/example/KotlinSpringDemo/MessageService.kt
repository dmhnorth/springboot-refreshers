package com.example.KotlinSpringDemo

import com.example.KotlinSpringDemo.domain.Message
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(private val db: JdbcTemplate) {
    /*
    Uses trailing lambda style.
    You could declare RowMapper for the second param in db.query but given the last parameter is a lambda, it can appear outside the brackets.
    The underscore is simply to denote unused parameters you don't use in a given lambda.
     */
    fun findMessages(): List<Message> = db.query("select * from messages") { response, _ ->
        Message(response.getString("id"), response.getString("some text"))
    }

    fun save(message: Message): Message {
        val id = message.id ?: UUID.randomUUID().toString()
        db.update(
            "insert into messages values ( ?, ? )",
            id, message.text
        )
        return message.copy(id = id)
    }
}