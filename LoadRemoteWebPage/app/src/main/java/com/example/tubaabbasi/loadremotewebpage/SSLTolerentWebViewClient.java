package com.example.tubaabbasi.loadremotewebpage;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by tubaabbasi on 11/11/16.
 */
public class SSLTolerentWebViewClient extends WebViewClient {

    @Override public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error)
    {
        handler.proceed(); // Ignore SSL certificate errors
    }
}
