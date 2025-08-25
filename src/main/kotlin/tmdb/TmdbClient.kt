package com.hennyboysmovieclub.tmdbRequests

import com.hennyboysmovieclub.tmdbRequests.requests.TmdbRequestInterface
import io.ktor.client.HttpClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class TmdbClient (
    val httpClient: HttpClient? = HttpClient()
) {
    suspend fun sendRequest (tmdbRequest: TmdbRequestInterface): String {
        // this need a more durable safe configuration, for now just paste the api key in and delete before commiting.
        val API_KEY: String = ""

        val request = tmdbRequest.buildRequest().apply {
            header("accept", "application/json")
            header("Authorization", API_KEY)
        }

        val response = httpClient!!.get(request)

        return response.bodyAsText() //in the long run we don't wanna return as text, but this is for testing
    }
}