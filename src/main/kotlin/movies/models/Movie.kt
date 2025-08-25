package com.hennyboysmovieclub.movies.models

data class Movie(
    val movieId: String,
    val tmdbId: String,
    val requestingUserId: String,
    val watched: Boolean
)
