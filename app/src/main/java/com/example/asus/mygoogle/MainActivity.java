package com.example.asus.mygoogle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private WebView WB;

    @Override
    public void onBackPressed(){
        if(WB.canGoBack()){
            WB.goBack();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WB=(WebView)findViewById(R.id.main_webview);

        WB.getSettings().setJavaScriptEnabled(true);
        WB.getSettings().setAppCacheEnabled(true);

        WB.loadUrl("https://google.com");

        WB.setWebViewClient(new WebViewClient());
    }
}
