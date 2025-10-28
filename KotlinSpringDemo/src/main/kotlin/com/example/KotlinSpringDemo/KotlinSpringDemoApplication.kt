package com.example.KotlinSpringDemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
//@RestController is not allowed here, unlike in Java!
class KotlinSpringDemoApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringDemoApplication>(*args)
}

/*
To manually run this:
./gradlew bootRun

Then navigate to

http://localhost:8080/

An Optional parameter
http://localhost:8080/hello?name=Dave
 */