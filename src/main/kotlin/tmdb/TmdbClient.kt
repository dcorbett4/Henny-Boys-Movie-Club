package com.hennyboysmovieclub.tmdbRequests

import com.hennyboysmovieclub.tmdbRequests.requests.TmdbRequestInterface
import io.ktor.client.HttpClient
import io.ktor.client.call.*
import io.ktor.client.request.*

class TmdbClient (
    val httpClient: HttpClient? = HttpClient()
) {
    suspend fun sendRequest (tmdbRequest: TmdbRequestInterface) {
        // this need a more durable safe configuration, for now just paste the api key in and delete before commiting.
        val API_KEY: String = ""

        val request = tmdbRequest.buildRequest().apply {
            header("accept", "application/json")
            header("Authorization", API_KEY)
        }

        try {
            val response = httpClient!!.get(request)
            println("Response Recieved!")
            return response.body()
        } catch (e: Exception) {
            println(e)
        }
    }
}