package com.hennyboysmovieclub.tmdbRequests

import io.ktor.client.HttpClient
import io.ktor.client.request.*
import io.ktor.client.request.headers
import io.ktor.client.statement.*

class TmdbClient (
    val httpClient: HttpClient? = HttpClient()
) {
    suspend fun getMovieByName(
        movieName: String,
    ): String {
        val queryParam: String = "query=$movieName"

        // this need a more durable safe configuration, for now just paste the api key in and delete before commiting.
        val API_KEY: String = ""

        val response = this.httpClient!!.get("https://api.themoviedb.org/3/search/movie?$queryParam&include_adult=false&language=en-US&page=1") {
            headers {
                append("accept", "application/json")
                append("Authorization", API_KEY)
            }
        }

        return response.bodyAsText()
    }
}