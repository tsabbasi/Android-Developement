package com.example.tubaabbasi.loadstatichtmlstring2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView browser;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        browser=(WebView)findViewById(R.id.webkit);

        browser.loadData("<html><body><div style=background-color:yellow;color:red>Hello, world!</div></body></html>",
                "text/html", "UTF-8");
    }
}