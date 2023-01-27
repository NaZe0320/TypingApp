package com.naze.typingapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimeViewModel:ViewModel() {
    private var _time: MutableLiveData<String> = MutableLiveData("00:00")
    val time get() = _time

    private var _max: MutableLiveData<Int> = MutableLiveData(60) //임시
    val max get() = _max

    private var _timeCount: MutableLiveData<Int> = MutableLiveData(0)
    val timeCount get() = _timeCount

    fun timerStart() {
        _timeCount.value = (_timeCount.value ?: 0) + 1
        _time.value = "00:01"
        Log.d("LiveDataTest","${timeCount.value}")
    }
}