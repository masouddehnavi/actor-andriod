package com.actor.app
import android.app.*
import android.os.Bundle
import android.webkit.*
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.webkit.ValueCallback

class MainActivity: Activity() {
    private lateinit var web: WebView
    private var chooser: ValueCallback<Array<Uri>>? = null
    private val PICK = 1001
    override fun onCreate(b: Bundle?) {
        super.onCreate(b); setContentView(com.actor.app.R.layout.activity_main)
        web=findViewById(com.actor.app.R.id.web)
        web.settings.javaScriptEnabled=true
        web.settings.domStorageEnabled=true
        web.settings.databaseEnabled=true
        web.settings.cacheMode=WebSettings.LOAD_DEFAULT
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(web,true)
        web.settings.allowFileAccess=true
        web.webViewClient=object:WebViewClient(){
            override fun shouldOverrideUrlLoading(view:WebView?, request:WebResourceRequest?)=false
            override fun onPageFinished(view:WebView?, url:String?){ super.onPageFinished(view,url); CookieManager.getInstance().flush() }
        }
        web.webChromeClient=object:WebChromeClient(){
            override fun onShowFileChooser(v:WebView?, cb:ValueCallback<Array<Uri>>?, p:FileChooserParams?):Boolean{
                chooser?.onReceiveValue(null); chooser=cb
                return try { startActivityForResult(p?.createIntent() ?: Intent(Intent.ACTION_GET_CONTENT).apply{type="*/*"},PICK); true } catch(e:Exception){ chooser=null; false }
            }
        }
        web.loadUrl("https://actor-backend-f1my.onrender.com")
    }
    override fun onActivityResult(r:Int,c:Int,d:Intent?){ super.onActivityResult(r,c,d); if(r==PICK){ chooser?.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(c,d)); chooser=null } }
    override fun onBackPressed(){ if(web.canGoBack()) web.goBack() else super.onBackPressed() }
}