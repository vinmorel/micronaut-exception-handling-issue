package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import kotlinx.coroutines.*

@Controller
class Controller {

    val scope = CoroutineScope(Job())

    @Get("/throw")
    fun throwDummyException() {
        scope.launch {
            throw DummyException()
        }
    }
}