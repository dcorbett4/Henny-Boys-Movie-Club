package com.hennyboysmovieclub.tmdbRequests.requests

import io.ktor.client.request.*

class SearchMoviesByNameRequest (
    private val movieName: String,
    private val releaseYear: String? = null,
    private val primaryLanguage: String? = "en-US",
): TmdbRequestInterface {
    override fun buildRequest(): HttpRequestBuilder {
        val requestBuilder = HttpRequestBuilder().apply {
            url(prepareUrl())
        }

        return requestBuilder
    }

    private fun prepareUrl(): String {
        var newUrl = appendUrlParameters("https://api.themoviedb.org/3/search/movie?", "query", this.movieName)
        this.releaseYear?.let {
            newUrl = appendUrlParameters(newUrl, "&primary_release_year", this.releaseYear)
        }
        this.primaryLanguage?.let {
            newUrl = appendUrlParameters(newUrl, "&language", this.primaryLanguage)
        }

        return newUrl
    }

    private fun appendUrlParameters(url: String, paramKey: String, paramValue: String): String {
        return "$url$paramKey=$paramValue"
    }
}