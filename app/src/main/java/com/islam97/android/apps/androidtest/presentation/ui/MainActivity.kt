package com.islam97.android.apps.androidtest.presentation.ui

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_INDEFINITE
import com.google.android.material.snackbar.Snackbar
import com.islam97.android.apps.androidtest.R
import com.islam97.android.apps.androidtest.common.ViewState
import com.islam97.android.apps.androidtest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var loading: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        loading = LoadingDialog(this)

        viewBinding.articlesList.layoutManager = LinearLayoutManager(this)
        viewBinding.articlesList.addItemDecoration(object :ItemDecoration(){
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.bottom=48
                outRect.top = 48
                outRect.right = 8
                outRect.left = 8
            }
        })

        viewModel.articlesLiveData.observe(this) {

            when (it) {
                is ViewState.Loading -> {
                    loading.show()
                }

                is ViewState.Success -> {
                    viewBinding.articlesList.adapter= ArticlesAdapter(it.data)
                    loading.dismiss()
                }

                is ViewState.Error -> {
                    Snackbar.make(viewBinding.rootLayout, it.errorMessage, LENGTH_INDEFINITE)
                        .setAction("Retry"){
                            viewModel.getArticles()
                        }
                        .show()
                    loading.dismiss()
                }
            }
        }
        viewModel.getArticles()
    }
}