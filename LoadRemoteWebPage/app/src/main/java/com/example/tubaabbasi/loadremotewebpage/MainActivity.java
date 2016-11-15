package com.example.tubaabbasi.loadremotewebpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;


public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView webview = new WebView(this);

        webview.getSettings().setJavaScriptEnabled(true);

        webview.setWebViewClient( new SSLTolerentWebViewClient() );

        webview.loadUrl("https://www.google.com/");

        setContentView(webview);
    }
}
