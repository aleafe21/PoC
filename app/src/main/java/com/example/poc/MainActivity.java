package com.example.poc;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url="https://192.168.0.1/login.asp";


        WebView myWebView = (WebView) findViewById(R.id.web);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        myWebView.setWebViewClient(new SSLTolerentWebViewClient());

        //myWebView.loadUrl("javascript: document.getElementById('username').value = '" + username + "';" + " document.getElementById('password').value = '" + password + "';" + "var z = document.getElementById('submit').click();" );

        myWebView.loadUrl(url);



    }

    private class SSLTolerentWebViewClient extends WebViewClient {
        public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {

            handler.proceed(); // Ignore SSL certificate errors
        }
        public void onPageFinished(WebView view, String url) {
            String user="admin";
            String pwd="admin";
            view.loadUrl("javascript:document.querySelector(\"#AutoNumber1 > tbody > tr:nth-child(1) > td:nth-child(2) > div:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(2) > input[type=username]\").value = '"+user+"';document.querySelector(\"#AutoNumber1 > tbody > tr:nth-child(1) > td:nth-child(2) > div:nth-child(2) > table > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=password]\").value='"+pwd+"';"+ "document.querySelector(\"#AutoNumber1 > tbody > tr:nth-child(1) > td:nth-child(2) > div:nth-child(2) > table > tbody > tr:nth-child(4) > td > input[type=submit]\").click();");
        }
    }


    }










