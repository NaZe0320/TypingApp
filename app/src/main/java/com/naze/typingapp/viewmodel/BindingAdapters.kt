package com.naze.typingapp.viewmodel

import android.util.Log
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

object BindingAdapters {

    @BindingAdapter(value = ["app:progress", "android:max"], requireAll = true)
    @JvmStatic fun setProgress(progressBar: ProgressBar, count: Int, max: Int) {
        Log.d("BindingAdapter","count: $count, max = $max")
        progressBar.progress = count
        progressBar.max = max
    }
}