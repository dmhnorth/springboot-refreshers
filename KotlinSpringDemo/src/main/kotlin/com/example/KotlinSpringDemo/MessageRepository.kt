package com.example.KotlinSpringDemo

import com.example.KotlinSpringDemo.domain.Message
import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message, String>