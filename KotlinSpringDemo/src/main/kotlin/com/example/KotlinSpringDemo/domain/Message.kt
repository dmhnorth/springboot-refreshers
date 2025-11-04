package com.example.KotlinSpringDemo.domain

data class ImmutableMessage (val id: String?, val text: String)

data class MutableMessage (var id: String?, var text: String)