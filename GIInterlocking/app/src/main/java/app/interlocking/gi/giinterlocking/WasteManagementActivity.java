package app.interlocking.gi.giinterlocking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class WasteManagementActivity extends AppCompatActivity {

    WebView mywebView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waste_management);


        mywebView = findViewById(R.id.webview);

        TextView textView = findViewById(R.id.link);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WebSettings webSettings = mywebView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                mywebView.loadUrl("https://en.wikipedia.org/wiki/Waste_management");
                mywebView.setWebViewClient(new WebViewClient());
                mywebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

            }
        });
    }
}
