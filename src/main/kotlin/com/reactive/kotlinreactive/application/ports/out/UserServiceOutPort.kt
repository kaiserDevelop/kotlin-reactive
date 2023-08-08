package com.reactive.kotlinreactive.application.ports.out

import com.reactive.kotlinreactive.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserServiceOutPort {

    suspend fun saveUser(user: User): User

    suspend fun getAllUsers(): Flow<User>


}