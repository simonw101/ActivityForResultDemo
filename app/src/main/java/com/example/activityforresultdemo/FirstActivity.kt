package com.example.activityforresultdemo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityforresultdemo.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirstBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnFinish.setOnClickListener {

            setResult(Activity.RESULT_OK)
            finish()

        }
    }
}