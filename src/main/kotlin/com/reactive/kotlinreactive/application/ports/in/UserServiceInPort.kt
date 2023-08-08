package com.reactive.kotlinreactive.application.ports.`in`

import com.reactive.kotlinreactive.application.dto.UserDTO
import com.reactive.kotlinreactive.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserServiceInPort {

    suspend fun save(user: UserDTO): User

    suspend fun allUsers(): Flow<User>

    suspend fun testCoroutines(): String


}