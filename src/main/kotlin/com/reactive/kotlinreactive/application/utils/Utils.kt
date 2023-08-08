package com.reactive.kotlinreactive.application.utils

import kotlinx.coroutines.delay

class Utils {

    suspend fun doWorld(): String {
        delay(1000L)
        println("World")
        return "World"
    }
}