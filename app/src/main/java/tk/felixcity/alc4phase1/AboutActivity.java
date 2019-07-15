package tk.felixcity.alc4phase1;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutActivity extends AppCompatActivity {

    WebView webView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar about = findViewById(R.id.aboutt);
        setSupportActionBar(about);

         webView = findViewById(R.id.webview);

         webView.setWebViewClient(new WebViewClient(){
             @Override
             public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {

                 handler.proceed();
                 //super.onReceivedSslError(view, handler, error);
             }
         });

     //    webView.getSettings().setLoadsImagesAutomatically(true);
         webView.getSettings().setJavaScriptEnabled(true);
     //    webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
         webView.loadUrl("https://andela.com/alc/");








    }



}
