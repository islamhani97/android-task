package com.islam97.android.apps.androidtest.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.islam97.android.apps.androidtest.R
import com.islam97.android.apps.androidtest.databinding.ItemArticleBinding
import com.islam97.android.apps.androidtest.domain.models.Result

class ArticlesAdapter(private val data: List<Result>) :
    Adapter<ArticlesAdapter.ArticleItemViewHolder>() {

    class ArticleItemViewHolder(val viewBinding: ItemArticleBinding) : ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleItemViewHolder {
        return ArticleItemViewHolder(
            DataBindingUtil.inflate<ItemArticleBinding>(
                LayoutInflater.from(
                    parent.context
                ), R.layout.item_article, parent, false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ArticleItemViewHolder, position: Int) {
        holder.viewBinding.item = data[position]
    }
}