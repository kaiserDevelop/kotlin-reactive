package com.reactive.kotlinreactive.application.usecases

import com.reactive.kotlinreactive.application.dto.UserDTO
import com.reactive.kotlinreactive.application.dto.toModel
import com.reactive.kotlinreactive.application.ports.`in`.UserServiceInPort
import com.reactive.kotlinreactive.application.ports.out.UserServiceOutPort
import com.reactive.kotlinreactive.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service

@Service
@Slf4j
class UserServiceImpl(private val userServiceOutPort: UserServiceOutPort): UserServiceInPort {
    override fun save(user: UserDTO): Flow<User> {
       return flow{
           println("Test")
           emit(userServiceOutPort.saveUser(user.toModel()))
       }
    }
}