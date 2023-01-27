package com.naze.typingapp.feature.practice

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.naze.typingapp.R
import com.naze.typingapp.databinding.ActivityLongPracticeBinding
import com.naze.typingapp.factory.ViewModelFactory
import com.naze.typingapp.viewmodel.PracticeViewModel
import com.naze.typingapp.viewmodel.TimeViewModel

class LongPracticeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLongPracticeBinding

    private lateinit var navLongPractice: NavController

    private lateinit var practiceViewModel : PracticeViewModel
    private lateinit var timeViewModel: TimeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@LongPracticeActivity, R.layout.activity_long_practice)

        navLongPractice = (supportFragmentManager.findFragmentById(R.id.nav_long_practice) as NavHostFragment).findNavController()
        //replaceFragment(LongPracticeSettingFragment(), "LongPracticeSetting")
        setViewModel()
        binding.lifecycleOwner = this
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

/*    fun replaceFragment(fragment: Fragment, tag: String?=null) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_long_practice, fragment, tag)
        transaction.commit()
    }*/

    override fun onBackPressed() {
        finish()
    }

    private fun setViewModel() {
        //val repo
        val factory = ViewModelFactory()

        practiceViewModel = ViewModelProvider(this@LongPracticeActivity, factory)[PracticeViewModel::class.java]
        timeViewModel = ViewModelProvider(this@LongPracticeActivity, factory)[TimeViewModel::class.java]

    }
}