package com.islam97.android.apps.androidtest.presentation.ui

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.islam97.android.apps.androidtest.R


class LoadingDialog(context: Context) : Dialog(context) {
    init {
        setContentView(R.layout.dialog_loading)
        setCancelable(false)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun show() {
        if (!isShowing)
            super.show()
    }

    override fun dismiss() {
        if (isShowing)
            super.dismiss()
    }
}