package com.example.poc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url="http://www.saij.gob.ar/";
        //url="https://192.168.0.1";
    }

    public void abrir(View view){

        Intent intent; //declaro el intent
        intent= new Intent(this, Main2Activity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }



    }




