package com.islam97.android.apps.androidtest.common

sealed class ViewState<out T> {
    object Loading : ViewState<Nothing>()
    data class Success<T>(val data: T) : ViewState<T>()
    data class Error(val errorMessage: String) : ViewState<Nothing>()
}