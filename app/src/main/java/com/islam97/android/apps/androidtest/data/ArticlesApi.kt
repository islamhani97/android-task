package com.islam97.android.apps.androidtest.data

import com.islam97.android.apps.androidtest.domain.models.ArticlesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticlesApi {
    @GET("mostviewed/all-sections/{period}.json?api-key=d4q1Mr1Or4Am6rhoHuvtpkqE2gDp211P")
    suspend fun getArticles(@Path("period") period: String): ArticlesResponse
}