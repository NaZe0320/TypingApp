package com.naze.typingapp.feature.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.naze.typingapp.R
import com.naze.typingapp.data.source.State
import com.naze.typingapp.data.source.TimerState
import com.naze.typingapp.databinding.FragmentLongPracticeBinding
import com.naze.typingapp.util.CustomFragment
import com.naze.typingapp.util.makeToast
import com.naze.typingapp.viewmodel.TypingViewModel

class LongPracticeFragment: CustomFragment() {

    private lateinit var binding: FragmentLongPracticeBinding

    private lateinit var vm: TypingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_long_practice, container, false)
        val view = binding.root
        setViewModel()
        binding.typing = vm
        binding.lifecycleOwner = this.viewLifecycleOwner

        init() //초기세팅
        uiSetting() // ui 세팅
        setObserver() // observer 세팅
        return view
    }


    //초기 세팅
    private fun init() {
        vm.setTimerState(TimerState.Start)
    }

    // ViewModel 세팅
    private fun setViewModel() {
        vm = ViewModelProvider(requireActivity())[TypingViewModel::class.java]
    }
    // Observer 세팅
    private fun setObserver() {
        val timeObserver: Observer<State> = Observer {
            context?.makeToast("시간 종료")
        }
        vm.state.observe(requireActivity(),timeObserver)
    }


    // UI 세팅
    private fun uiSetting() {
        btnSetting()
    }

    private fun btnSetting() {
        binding.pauseBtn.setOnClickListener {
            vm.setTimerState(TimerState.Pause)
        }
    }


}