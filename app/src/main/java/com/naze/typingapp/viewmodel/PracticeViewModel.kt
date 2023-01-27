package com.naze.typingapp.viewmodel

import androidx.lifecycle.ViewModel

class PracticeViewModel: ViewModel() {

    private var _typeCount = 0
    val typeCount get() = _typeCount

    private var _progress = 0
    val progress get() = _progress

}