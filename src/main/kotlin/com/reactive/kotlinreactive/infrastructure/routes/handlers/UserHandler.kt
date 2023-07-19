package com.reactive.kotlinreactive.infrastructure.routes.handlers

import com.reactive.kotlinreactive.application.dto.UserDTO
import com.reactive.kotlinreactive.application.ports.`in`.UserServiceInPort
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.badRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Component
class UserHandler(private val userServiceInPort: UserServiceInPort) {

    suspend fun addUser(req: ServerRequest): ServerResponse {
        val receivedUser = req.awaitBodyOrNull(UserDTO::class)
        return receivedUser?.let {
            ok().bodyAndAwait(userServiceInPort.save(it))
        } ?: badRequest().buildAndAwait()
    }
}