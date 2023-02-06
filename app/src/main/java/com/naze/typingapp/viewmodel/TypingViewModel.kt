package com.naze.typingapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naze.typingapp.data.source.State
import com.naze.typingapp.data.source.TimerState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TypingViewModel:ViewModel() {

    private lateinit var job: Job
    private var coroutineScope = CoroutineScope(Dispatchers.Main)
    private var _timerFlow = MutableStateFlow<TimerState>(TimerState.UnInitialized)
    val timerFlow:StateFlow<TimerState> get() = _timerFlow

    private var _max: MutableLiveData<Int> = MutableLiveData(60) //임시
    val max:LiveData<Int> get() = _max
    //최대 시간

    private var _timeCount: MutableLiveData<Int> = MutableLiveData(0)
    val timeCount:LiveData<Int> get() = _timeCount
    //진행 시간(1초 단위)
    private var _timeSubCount: Int = 0
    //진행 시간 (100ms 단위) 일시정지했을 때 밀리는 시간 방지용

    private var _state: MutableLiveData<State> = MutableLiveData(State.None)
    val state:LiveData<State> get() = _state

    fun setTimerState(state: TimerState) = coroutineScope.launch {
        _timerFlow.emit(state)
        when (state) {
            is TimerState.Start -> startTimer()
            is TimerState.Finish -> finishTimer()
            is TimerState.Pause -> pauseTimer()
            TimerState.UnInitialized -> TODO()
        }
    }

    fun setMaxTime(time: String) {
        Log.d("ViewModel","TEST - TIME")
        try {
            _max.value = time.toInt()
        } catch (e: java.lang.NumberFormatException) {
            _max.value = 60
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
            checkFinish()
        }
    }

    private fun checkFinish() {
        if (_timeCount.value == _max.value) {
            _state.value = State.Finish
            Log.d("TEST_Typing","시간 종료")
            job.cancel()
        }
    }
}