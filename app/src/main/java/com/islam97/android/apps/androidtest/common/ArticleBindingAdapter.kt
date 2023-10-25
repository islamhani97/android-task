package com.islam97.android.apps.androidtest.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.islam97.android.apps.androidtest.R
import com.islam97.android.apps.androidtest.domain.models.Result


@BindingAdapter(value = ["loadImage"], requireAll = false)
fun loadImage(view: ImageView, item: Result?) {
    var url = ""
    if (item?.media?.isNotEmpty() == true && item?.media[0]?.mediaMetadata?.isNotEmpty() == true) {
        url = item.media[0].mediaMetadata[0].url
    }
    Glide.with(view).load(url).placeholder(R.drawable.ic_launcher_foreground).into(view)
}