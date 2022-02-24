package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.example.myapplication.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        binding.webView.settings.javaScriptEnabled = true //자바 스크립트 허용
        /* 웹 뷰에서는 새 창이 뜨지 않는 구문 거의 필수적인 옵션*/
        binding.webView.webViewClient = WebViewClient()
        binding.webView.webChromeClient = WebChromeClient()
        /* 웹 뷰에서는 새 창이 뜨지 않는 구문*/
        binding.webView.loadUrl("https://www.rainymood.com/")
    }

    override fun onBackPressed() { //백버튼 누를 시 수행할 로직 구현

        if (binding.webView.canGoBack())
        {//웹사이트에서 뒤로갈 페이지가 존재한다면
            binding.webView.goBack() //웹 사이트 뒤로가기
        } else {

            super.onBackPressed() //본래의 백버튼 기능 수행
        }
    }
}