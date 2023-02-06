package com.naze.typingapp.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.naze.typingapp.viewmodel.TypingViewModel

class ViewModelFactory(): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TypingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TypingViewModel() as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}