package com.example.time;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--- WebView Setup ---//
        myWebView = findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enable JavaScript
        webSettings.setDomStorageEnabled(true);   // Enable DOM Storage

        // This ensures that links you click inside the WebView open within the WebView itself
        myWebView.setWebViewClient(new WebViewClient());

        // Load your local HTML file from the 'assets' folder
        myWebView.loadUrl("file:///android_asset/index.html");


        //--- Back Button Press Handling ---//
        // This code correctly handles the back button for WebView navigation.
        // It must be placed inside a method like onCreate().
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // If the WebView can go back, it will.
                if (myWebView.canGoBack()) {
                    myWebView.goBack();
                } else {
                    // Otherwise, the activity will be finished (closed).
                    finish();
                }
            }
        });
    }
}