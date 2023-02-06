package com.naze.typingapp.data.source

sealed class TimerState {
    object UnInitialized: TimerState()
    object Start: TimerState()
    object Pause: TimerState()
    object Finish: TimerState()
}

