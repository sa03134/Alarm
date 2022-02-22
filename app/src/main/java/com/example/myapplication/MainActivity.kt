package com.example.myapplication



import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnSub.setOnClickListener{
            val intent = Intent(this,SubActivity::class.java)
            intent.putExtra("msg",binding.tvSendMsg.text.toString())
            startActivity(intent)
        }

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ISO_LOCAL_TIME
        val formatted = current.format(formatter)



        binding.btnToast.setOnClickListener {
            binding.ivProfile.setImageResource(R.drawable.sleepingcolor)
            Toast.makeText(this, formatted, Toast.LENGTH_SHORT).show()
        }


    }
}
