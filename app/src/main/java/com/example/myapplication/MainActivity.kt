package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        binding.tv.text = "가즈아"
//        binding.btnTest.text="보여?"

    }

    var state = true
    fun funTest(view: View) {

        state = !state
        if (state) {
            binding.tv.text = "true"
            binding.tvSub.text ="해냈다"
        } else {
            binding.tv.text = "false"
            binding.tvSub.text ="요롤레이 요호호"
        }
    }

}


