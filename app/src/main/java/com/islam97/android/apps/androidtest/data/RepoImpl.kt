package com.islam97.android.apps.androidtest.data

import com.islam97.android.apps.androidtest.domain.models.ArticlesResponse
import com.islam97.android.apps.androidtest.domain.repo.Repo
import javax.inject.Inject

class RepoImpl
@Inject
constructor(private val api: ArticlesApi) : Repo {

    override suspend fun getArticles(period: String): ArticlesResponse {
        return api.getArticles(period)
    }
}