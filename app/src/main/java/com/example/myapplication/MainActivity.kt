package com.example.myapplication



import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        Toast.makeText(this, binding.tvSendMsg.text, Toast.LENGTH_SHORT).show( )

        binding.btnSub.setOnClickListener{
            val intent = Intent(this,SubActivity::class.java)
            intent.putExtra("msg",binding.tvSendMsg.text.toString())
            startActivity(intent)
        }


    }
}
