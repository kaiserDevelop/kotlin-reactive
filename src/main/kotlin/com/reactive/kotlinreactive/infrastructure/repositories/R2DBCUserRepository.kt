package com.reactive.kotlinreactive.infrastructure.repositories

import com.reactive.kotlinreactive.domain.model.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface R2DBCUserRepository: CoroutineCrudRepository<User, Int> {
}