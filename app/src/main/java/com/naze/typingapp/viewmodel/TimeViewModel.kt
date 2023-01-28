package com.naze.typingapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naze.typingapp.data.source.TimerState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow

class TimeViewModel:ViewModel() {


    private lateinit var job: Job
    private var coroutineScope = CoroutineScope(Dispatchers.Main)
    private var _timerFlow = MutableStateFlow<TimerState>(TimerState.UnInitialized)
    val timerFlow get() = _timerFlow

    private var _time: MutableLiveData<String> = MutableLiveData("00:00")
    val time get() = _time

    private var _max: MutableLiveData<Int> = MutableLiveData(60) //임시
    val max get() = _max

    private var _timeCount: MutableLiveData<Int> = MutableLiveData(0)
    val timeCount get() = _timeCount

    private var _timeSubCount: Int = 0

    fun setTimerState(state: TimerState) = coroutineScope.launch {
        _timerFlow.emit(state)
        when (state) {
            is TimerState.Start -> startTimer()
            is TimerState.Finish -> finishTimer()
            is TimerState.Pause -> pauseTimer()
            TimerState.UnInitialized -> TODO()
        }
    }

    private fun startTimer() {
        if (::job.isInitialized) {
            job.cancel()
            clearTimerCount()
        }
        job = timeSubCounting()
    }

    private fun pauseTimer() {
        if (job.isActive) job.cancel()
        else job = timeSubCounting()
    }

    private fun finishTimer() {
        if (::job.isInitialized) {
            Log.d("CustomTimer","finish")
            job.cancel()
            clearTimerCount()
        }
    }

    private fun clearTimerCount() {
        _timeCount.value = 0
        _timeSubCount = 0
        Log.d("CustomTimer","Clear")
    }

    private fun timeSubCounting() = viewModelScope.launch {
        while (true) {
            while (_timeSubCount <= 20) {
                _timeSubCount += 1
                delay(50L)
            }
            _timeSubCount = 0
            _timeCount.value = (_timeCount.value ?: 0) + 1
        }
    }
}