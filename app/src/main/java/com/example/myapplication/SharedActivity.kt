package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivitySharedBinding

class SharedActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySharedBinding
    override fun onCreate(savedInstanceState: Bundle?) { //해당 액티비티가 처음 실행될 때 한번 수행하는 곳 (초기화)
        super.onCreate(savedInstanceState)
        binding = ActivitySharedBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)


        //TODO 저장된 데이터를 로드
        loadData() //edit text 저장 되어 있던 값을 불러오는 로직
    }

    private fun loadData() {
        val pref = getSharedPreferences("pref", 0) //내부 저장 경로에 pref 라고 입력하겠다. mode 는 0 으로
        binding.etHello.setText(pref.getString("name","")) // 1번째 인자에다가는 저장할 당시의 키값을 2번째 인자에는 키 값에 데이터가 존재하지 않을 경우 대체값.
    }

    override fun onDestroy() { //액티비티가 종료되는 시점이 다가올때 호출
        super.onDestroy()

        saveData() //edit text 값을 저장하는 로직
    }

    private fun saveData() {
        val pref = getSharedPreferences("pref", 0) //내부 저장 경로에 pref 라고 입력하겠다. mode 는 0 으로
        val edit = pref.edit() //수정모드
        edit.putString("name",binding.etHello.text.toString()) //1번째 인자에는 키 값을, 2번째 인자에는 실제 담아둘 값을
        edit.apply() //저장완료


    }
}