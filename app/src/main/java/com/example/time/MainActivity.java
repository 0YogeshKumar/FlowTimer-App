package com.example.time;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enable JavaScript if your HTML uses it

        // Optional: Enable DOM storage for local storage, etc.
        webSettings.setDomStorageEnabled(true);

        // Optional: Set a WebViewClient to handle redirects within the WebView
        myWebView.setWebViewClient(new WebViewClient());

        // Load your HTML file from the assets folder
        // Replace "your_html_folder_name/index.html" with the correct path
        myWebView.loadUrl("file:///android_asset/index.html");
    }

    // Optional: Handle back button press to navigate WebView history
    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
