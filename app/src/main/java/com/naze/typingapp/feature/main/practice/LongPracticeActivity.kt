package com.naze.typingapp.feature.main.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.naze.typingapp.R
import com.naze.typingapp.databinding.ActivityLongPracticeBinding

class LongPracticeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLongPracticeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@LongPracticeActivity, R.layout.activity_long_practice)

        //Action Bar 설정
        setSupportActionBar(binding.toolbarLongPractice)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}