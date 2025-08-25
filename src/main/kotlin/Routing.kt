package com.hennyboysmovieclub

import com.hennyboysmovieclub.tmdbRequests.TmdbClient
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/search") {
            val name: String = call.parameters["name"].toString()
            println("search!")
            val tmdbClient = TmdbClient()
            call.respond(tmdbClient.getMovieByName(name))
        }
    }
}
