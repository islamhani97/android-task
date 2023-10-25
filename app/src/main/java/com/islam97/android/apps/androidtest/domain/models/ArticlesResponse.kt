package com.islam97.android.apps.androidtest.domain.models

data class ArticlesResponse(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)