package com.naze.typingapp.feature.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.naze.typingapp.R
import com.naze.typingapp.databinding.FragmentLongPracticeBinding
import com.naze.typingapp.util.CustomFragment

class LongPracticeFragment: CustomFragment() {

    private lateinit var binding: FragmentLongPracticeBinding

    companion object {
        fun newInstance() = LongPracticeFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_long_practice, container, false)
        val view = binding.root
        return view
    }
}