package com.hennyboysmovieclub

import com.hennyboysmovieclub.tmdbRequests.TmdbClient
import com.hennyboysmovieclub.tmdbRequests.TmdbService
import com.hennyboysmovieclub.tmdbRequests.requests.SearchMoviesByNameRequest
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
            val request = SearchMoviesByNameRequest(name)
            val tmdbService = TmdbService()

            call.respondText(tmdbService.sendRequest(request))
        }
    }
}
