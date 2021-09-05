package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.graphics.Bitmap
import android.util.Log
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_BACK





class WebViewActivity : AppCompatActivity() {

    lateinit var webView :WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        webView = findViewById(R.id.webview)
        webView.loadUrl("https://m.baidu.com")
        var settings = webView.settings
        settings.javaScriptEnabled = true
        webView.webViewClient = MyWebViewClient();
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}

class MyWebViewClient :WebViewClient(){
    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        Log.d("KeithXiaoY", "开始加载")
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        Log.d("KeithXiaoY", "加载结束")
    }

    // 链接跳转都会走这个方法
    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        Log.d("KeithXiaoY", "Url：$url")
        view.loadUrl(url) // 强制在当前 WebView 中加载 url
        return true
    }
}