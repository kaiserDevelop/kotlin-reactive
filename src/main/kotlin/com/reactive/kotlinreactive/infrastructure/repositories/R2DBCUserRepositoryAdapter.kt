package com.reactive.kotlinreactive.infrastructure.repositories

import com.reactive.kotlinreactive.application.ports.out.UserServiceOutPort
import com.reactive.kotlinreactive.domain.model.User
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Repository

@Repository
class R2DBCUserRepositoryAdapter(private val r2DBCUserRepository: R2DBCUserRepository): UserServiceOutPort {

    override suspend fun saveUser(user: User) = r2DBCUserRepository.save(user)
    override suspend fun getAllUsers(): Flow<User> = r2DBCUserRepository.findAll()
}