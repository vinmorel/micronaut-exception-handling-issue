package com.example

import io.micronaut.context.annotation.Requirements
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton

class DummyException : RuntimeException()

@Produces
@Singleton
@Requirements(
    Requires(classes = [DummyException::class, ExceptionHandler::class])
)
class DummyExceptionHandler : ExceptionHandler<DummyException, HttpResponse<*>> {
    override fun handle(request: HttpRequest<*>?, exception: DummyException?): HttpResponse<String> {
        println("handle $exception")
        return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR, "Dummy Exception")
    }
}
