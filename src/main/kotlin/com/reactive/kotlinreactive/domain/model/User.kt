package com.reactive.kotlinreactive.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("users")
data class User(
    @Id val id: Int?,
    val name: String,
    @Column("last_name")
    val lastName: String,
    val age: Int,
    val email: String,
)
