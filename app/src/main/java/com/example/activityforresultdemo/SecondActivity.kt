package com.example.activityforresultdemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityforresultdemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.button.setOnClickListener {

            val intent = Intent()

            intent.putExtra(MainActivity.NAME, binding.editTextTextPersonName.text.toString())
            intent.putExtra(MainActivity.EMAIL, binding.editTextTextEmailAddress.text.toString())

            setResult(Activity.RESULT_OK, intent)

            finish()

        }
    }
}