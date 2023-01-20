package com.naze.typingapp.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.naze.typingapp.viewmodel.PracticeViewModel
import com.naze.typingapp.viewmodel.TimeViewModel

class ViewModelFactory(): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PracticeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PracticeViewModel() as T
        } else if (modelClass.isAssignableFrom(TimeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TimeViewModel() as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}