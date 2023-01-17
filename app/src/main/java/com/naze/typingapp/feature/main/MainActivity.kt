package com.naze.typingapp.feature.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import com.naze.typingapp.R
import com.naze.typingapp.databinding.ActivityMainBinding
import com.naze.typingapp.feature.practice.LongPracticeActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setMenuList()

        binding.btnLicense.setOnClickListener {
            OssLicensesMenuActivity.setActivityTitle("오픈소스 라이센스 목록")
            startActivity(Intent(this, OssLicensesMenuActivity::class.java))
        }

        binding.btnTest.setOnClickListener {
            val intent = Intent(this, LongPracticeActivity::class.java)
            startActivity(intent)
        }
    }



    private fun setMenuList() {
        binding.rvMenuList.apply {
            adapter = MainExpandableListAdapter()
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }
}