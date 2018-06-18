package com.example.asus.mygoogle;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private WebView WebV;
    private ProgressBar ProgB;
    private ImageView ImgV;

    @Override
    public void onBackPressed(){
        if(WebV.canGoBack()){
            WebV.goBack();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProgB=(ProgressBar)findViewById(R.id.pb);
        WebV=(WebView)findViewById(R.id.main_webview);
        ImgV=(ImageView)findViewById(R.id.imageview);
        WebV.getSettings().setJavaScriptEnabled(true);
        WebV.setWebChromeClient(new WebChromeClient() {

                                    @Override
                                    public void onProgressChanged(WebView view, int newProgress) {
                                        super.onProgressChanged(view, newProgress);
                                        ProgB.setProgress(newProgress);
                                    }



                                });

        WebV.getSettings().setAppCacheEnabled(true);

        WebV.loadUrl("https://google.com");

        WebV.setWebViewClient(new WebViewClient());
    }
}
