package com.hennyboysmovieclub.tmdbRequests.requests

import io.ktor.client.request.*

interface TmdbRequestInterface {
    fun buildRequest(): HttpRequestBuilder
}