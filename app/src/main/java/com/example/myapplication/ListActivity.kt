package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.myapplication.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding


    var UserList = arrayListOf<User>(
        User("08:10", "어머니전화", "잠금", R.drawable.bell),
        User("09:30", "조깅", "잠금", R.drawable.bell),
        User("09:15", "빨래", "잠금", R.drawable.bell),
        User("10:20", "도서관", "잠금", R.drawable.bellcolor),
        User("11:10", "공부", "잠금", R.drawable.bell),
        User("12:40", "병원", "잠금", R.drawable.bell),

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var testText = intent.getStringExtra("test")
        println(testText)
        if (intent.hasExtra("test")) {
            Toast.makeText(this, testText, Toast.LENGTH_LONG).show()
        }

//        val item = arrayOf("08:10","08:10","08:10","08:10","08:10")
//        binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, item)

        val adapter = UserAdapter(this, UserList)
        binding.listView.adapter = adapter

        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectItem = parent.getItemAtPosition(position) as User

                Toast.makeText(this, selectItem.time, Toast.LENGTH_SHORT).show()

            }

    }
}