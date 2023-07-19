package com.reactive.kotlinreactive.application.dto

import com.reactive.kotlinreactive.domain.model.User

data class UserDTO(
    val name: String,
    val lastName: String,
    val age: Int,
    val email: String,
)

fun UserDTO.toModel(): User = User(
    id = null,
    name = name,
    lastName = lastName,
    age = age,
    email = email
    )