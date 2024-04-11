package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity2 extends AppCompatActivity {

    WebView w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        w=findViewById(R.id.web);
        w.setWebViewClient(new WebViewClient());
        Intent i=getIntent();
        String extra = i.getStringExtra("load");
        if(extra.equals("default12"))
        {
            w.loadUrl("https://www.google.com/");
        }
        else w.loadUrl(extra);
    }
}