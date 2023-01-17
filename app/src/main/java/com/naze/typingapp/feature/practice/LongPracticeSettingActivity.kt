package com.naze.typingapp.feature.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.naze.typingapp.R
import com.naze.typingapp.databinding.ActivityLongPracticeSettingBinding

class LongPracticeSettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLongPracticeSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@LongPracticeSettingActivity, R.layout.activity_long_practice_setting)


    }
}