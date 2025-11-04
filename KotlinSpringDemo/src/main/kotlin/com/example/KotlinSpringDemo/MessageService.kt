package com.example.KotlinSpringDemo

import com.example.KotlinSpringDemo.domain.ImmutableMessage
import com.example.KotlinSpringDemo.domain.MutableMessage
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class MessageService(private val db: JdbcTemplate) {
    //Uses trailing lambda style
    fun findImmutableMessages(): List<ImmutableMessage> = db.query("select * from messages") { response, _ ->
        ImmutableMessage(response.getString("id"), response.getString("some text"))
    }

    fun save(message: ImmutableMessage): ImmutableMessage {
        val id = message.id ?: UUID.randomUUID().toString()
        db.update(
            "insert into messages values ( ?, ? )",
            id, message.text
        )
        return message.copy(id = id)
    }


    //Uses explicit type declaration of RowMapper, the underscore is simply an unused parameter
    fun findMutableMessages(): List<ImmutableMessage> = db.query("select * from messages", RowMapper { response, _ ->
        ImmutableMessage(response.getString("id"), response.getString("some text"))
    })

    fun saveMutable(message: MutableMessage): MutableMessage {
        db.update(
            "insert into messages values ( ?, ? )",
            message.id, message.text
        )
        return message
    }
}