package com.islam97.android.apps.androidtest.domain.repo

import com.islam97.android.apps.androidtest.domain.models.ArticlesResponse

interface Repo {
  suspend  fun getArticles( period: String):ArticlesResponse
}