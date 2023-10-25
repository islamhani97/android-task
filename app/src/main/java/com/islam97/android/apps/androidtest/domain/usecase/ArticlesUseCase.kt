package com.islam97.android.apps.androidtest.domain.usecase

import com.islam97.android.apps.androidtest.domain.models.ArticlesResponse
import com.islam97.android.apps.androidtest.domain.repo.Repo
import javax.inject.Inject

class ArticlesUseCase
@Inject
constructor(private val repo: Repo) {
    suspend operator fun invoke( period: String): ArticlesResponse {
        return repo.getArticles(period)
    }
}