package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityNaviBinding
import com.google.android.material.navigation.NavigationView

class NaviActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnNavi.setOnClickListener {
            binding.layoutDrawer.openDrawer(GravityCompat.START) //LEFT 와 같은 말. END : RIGHT
        }

        binding.naviView.setNavigationItemSelectedListener(this) //네비게이션 메뉴 아이템에 클릭 속성을 부여하는 것.
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean { //네비게이션 아이템 클릭시 수행하는 녀석
        when (item.itemId) {
            R.id.access -> Toast.makeText(applicationContext, "접근성", Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext, "이메일", Toast.LENGTH_SHORT).show()
            R.id.message -> Toast.makeText(applicationContext, "메시지", Toast.LENGTH_SHORT).show()

        }
        binding.layoutDrawer.closeDrawers() //네비게이션 뷰 닫기
        return false

    }

    override fun onBackPressed() { //백버튼 눌렀을때 수행하는 메소드
        if (binding.layoutDrawer.isDrawerOpen(GravityCompat.START)) {
            binding.layoutDrawer.closeDrawers()
        } else {

            super.onBackPressed() //일반 백버튼 실행 (finish)
        }
    }
}