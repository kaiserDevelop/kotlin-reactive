package com.reactive.kotlinreactive.application.ports.`in`

import com.reactive.kotlinreactive.application.dto.UserDTO
import com.reactive.kotlinreactive.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserServiceInPort {

    fun save(user: UserDTO): Flow<User>


}