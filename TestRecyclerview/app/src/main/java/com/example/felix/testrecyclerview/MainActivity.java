package com.example.felix.testrecyclerview;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView mywebView ;
    private ConnectivityManager connectivityManager;
    private NetworkInfo networkInfo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mywebView = findViewById(R.id.webview);
        //  connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);


        mywebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                view.loadUrl("about:blank");

                view.loadUrl("file:///android_asset/myerrorpage.html");
                view.loadUrl("file:///android_asset/myerrorpage.html");


                //  Toast.makeText(this, "no network please on your data", Toast.LENGTH_SHORT).show();
            }

            //  Toast.makeText(this, "no network please on your data", Toast.LENGTH_SHORT).show();
        });

        WebSettings webSettings = mywebView.getSettings();
        mywebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setJavaScriptEnabled(true);
        mywebView.loadUrl("http://cfwm.org.ng");

    }

    }


