package com.hennyboysmovieclub.tmdbRequests

import com.hennyboysmovieclub.tmdbRequests.requests.SearchMoviesByNameRequest
import com.hennyboysmovieclub.tmdbRequests.requests.TmdbRequestInterface

suspend fun main (args: Array<String>) {
    val tmdbService = TmdbService()
    val request = SearchMoviesByNameRequest("There Will Be Blood")

    tmdbService.sendRequest(request)
}


class TmdbService (
    private val tmdbClient: TmdbClient? = TmdbClient(),
) {
    suspend fun sendRequest (tmdbRequest: TmdbRequestInterface) {
        val testRespone = this.tmdbClient!!.sendRequest(tmdbRequest)
        
        println(testRespone)
    }
}