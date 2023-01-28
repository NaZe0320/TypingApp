package com.naze.typingapp.feature.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.naze.typingapp.R
import com.naze.typingapp.data.source.TimerState
import com.naze.typingapp.databinding.FragmentLongPracticeBinding
import com.naze.typingapp.util.CustomFragment
import com.naze.typingapp.viewmodel.PracticeViewModel
import com.naze.typingapp.viewmodel.TimeViewModel

class LongPracticeFragment: CustomFragment() {

    private lateinit var binding: FragmentLongPracticeBinding

    private lateinit var practiceVM: PracticeViewModel
    private lateinit var timeVM: TimeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_long_practice, container, false)
        val view = binding.root
        setViewModel()
        binding.time = timeVM
        binding.typing = practiceVM
        binding.lifecycleOwner = this.viewLifecycleOwner

        startTimer()
        btnSetting()
        return view
    }

    private fun setViewModel() {
        practiceVM = ViewModelProvider(requireActivity())[PracticeViewModel::class.java]
        timeVM = ViewModelProvider(requireActivity())[TimeViewModel::class.java]
    }

    private fun startTimer() {
        timeVM.setTimerState(TimerState.Start)
    }

    private fun btnSetting() {
        binding.pauseBtn.setOnClickListener {
            timeVM.setTimerState(TimerState.Pause)
        }
    }
}