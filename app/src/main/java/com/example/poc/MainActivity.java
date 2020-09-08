package com.example.poc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private String url;
    //private String username;
    //private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url="https://192.168.0.1/login.asp";
        //url="https://www.it-swarm.dev/es/android/net-err-access-denied-android-error-al-abrir-la-pagina-web-en-android-activity/811598125/";

        //username = "admin";
        //password = "admin";


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










