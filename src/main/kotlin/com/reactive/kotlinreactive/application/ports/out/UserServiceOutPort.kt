package com.reactive.kotlinreactive.application.ports.out

import com.reactive.kotlinreactive.domain.model.User

interface UserServiceOutPort {

    suspend fun saveUser(user: User): User


}