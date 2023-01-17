package com.naze.typingapp.feature.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.naze.typingapp.R
import com.naze.typingapp.databinding.FragmentLongPracticeSettingBinding
import com.naze.typingapp.util.CustomFragment


class LongPracticeSettingFragment: CustomFragment() {

    private lateinit var binding: FragmentLongPracticeSettingBinding
    private lateinit var navController: NavController

    companion object {
        fun newInstance() = LongPracticeSettingFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_long_practice_setting, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        binding.btnStart.setOnClickListener {
            navController.navigate(R.id.action_longPracticeSettingFragment_to_longPracticeFragment)
        }

    }

}