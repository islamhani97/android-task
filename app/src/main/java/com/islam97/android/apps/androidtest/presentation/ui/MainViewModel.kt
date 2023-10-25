package com.islam97.android.apps.androidtest.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.islam97.android.apps.androidtest.common.ViewState
import com.islam97.android.apps.androidtest.domain.models.Result
import com.islam97.android.apps.androidtest.domain.usecase.ArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val useCase: ArticlesUseCase) : ViewModel() {

    private val _articlesLiveData: MutableLiveData<ViewState<List<Result>>> = MutableLiveData()
    val articlesLiveData: LiveData<ViewState<List<Result>>> get() = _articlesLiveData

    fun getArticles() {
        _articlesLiveData.value = ViewState.Loading
        try {
            viewModelScope.launch {
                val resultA = async {
                    useCase.invoke("1")
                }
                val resultB = async {
                    useCase.invoke("30")
                }
                val articles: ArrayList<Result> = ArrayList()
                articles.addAll(resultA.await().results)
                articles.addAll(resultB.await().results)
                _articlesLiveData.value = ViewState.Success(articles)

            }
        } catch (e: Exception) {
            _articlesLiveData.value = ViewState.Error(e.message?:"Something went wrong!")
        }
    }

}