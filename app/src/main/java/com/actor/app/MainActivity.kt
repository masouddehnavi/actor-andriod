package com.actor.app
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
class MainActivity:AppCompatActivity(){override fun onCreate(b:Bundle?){super.onCreate(b);setContentView(R.layout.activity_main);val w=findViewById<WebView>(R.id.web);w.settings.javaScriptEnabled=true;w.settings.domStorageEnabled=true;w.settings.allowFileAccess=true;w.webViewClient=WebViewClient();w.loadUrl("file:///android_asset/index.html")}}