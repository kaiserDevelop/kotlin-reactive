package com.reactive.kotlinreactive.infrastructure.routes

import com.reactive.kotlinreactive.infrastructure.routes.handlers.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class UserRoute(private val userHandler: UserHandler) {

    @Bean
    fun apiRouter() = coRouter {
        "/v1/users".nest {
            accept(MediaType.APPLICATION_JSON).nest {
                contentType(MediaType.APPLICATION_JSON).nest {
                    POST("", userHandler::addUser)
                    GET("", userHandler::allUsers)
                    GET("/coroutines", userHandler::testCoroutines)
                }

            }
        }
    }
}