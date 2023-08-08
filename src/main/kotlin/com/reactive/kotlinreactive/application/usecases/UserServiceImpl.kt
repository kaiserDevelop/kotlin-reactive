package com.reactive.kotlinreactive.application.usecases

import com.reactive.kotlinreactive.application.dto.UserDTO
import com.reactive.kotlinreactive.application.dto.toModel
import com.reactive.kotlinreactive.application.ports.`in`.UserServiceInPort
import com.reactive.kotlinreactive.application.ports.out.UserServiceOutPort
import com.reactive.kotlinreactive.application.utils.Utils
import com.reactive.kotlinreactive.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
@Slf4j
class UserServiceImpl(private val userServiceOutPort: UserServiceOutPort): UserServiceInPort {

    val log: Logger = LoggerFactory.getLogger(UserServiceImpl::class.java)
    override suspend fun save(user: UserDTO): User = userServiceOutPort.saveUser(user.toModel())

    override suspend fun allUsers(): Flow<User> = userServiceOutPort.getAllUsers()
    override suspend fun testCoroutines() = coroutineScope {
        log.info("Starting - testCoroutines")
        var result: String? = null
        withContext(Dispatchers.IO) {
            log.info("Dispatchers.IO - testCoroutines")
            val utils = Utils()
            userServiceOutPort.getAllUsers().collect{log.info(it.email)}
            withContext(Dispatchers.Default) {
                result = utils.doWorld()
            }
        }
        delay(100L)
        userServiceOutPort.getAllUsers().collect{log.info(it.email)}
        log.info("Ending - testCoroutines")
        return@coroutineScope result ?: ""
    }
}