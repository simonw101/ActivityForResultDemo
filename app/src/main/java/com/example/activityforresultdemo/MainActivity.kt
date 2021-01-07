package com.example.activityforresultdemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.activityforresultdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {

        private const val FIRST_ACTIVITY_REQUEST_CODE = 1
        private const val SECOND_ACTIVITY_REQUEST_CODE = 2

        const val NAME = "name"
        const val EMAIL = "email"

    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonFirst.setOnClickListener {

            val intent = Intent(this, FirstActivity::class.java)
            startActivityForResult(intent, FIRST_ACTIVITY_REQUEST_CODE)

        }

        binding.buttonSecond.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {

            if (requestCode == FIRST_ACTIVITY_REQUEST_CODE) {

                binding.tvForFirst.text = "First Activity Result Success"

            } else if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {

                if (data != null) {

                    val name = data.getStringExtra(NAME)
                    val email = data.getStringExtra(EMAIL)
                    binding.tvForSecond.text = "$name $email"

                }

            }

        } else if (resultCode == Activity.RESULT_CANCELED) {

            Log.e("cancelled", "Cancelled")

            Toast.makeText(this@MainActivity, "Result Cancelled", Toast.LENGTH_LONG).show()

        }
    }
}