package com.shaji.internetcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialButton chekBtn = (MaterialButton) findViewById(R.id.check);
        chekBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnected())
                    Toast.makeText(getApplicationContext(), "INTERNET IS AVAILABLE", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "INTERNET IS NOT AVAILABLE", Toast.LENGTH_SHORT).show();

            }
        });
    }
    boolean isConnected(){
        ConnectivityManager connectivityManager =  (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null){
            if (networkInfo.isConnected())
                return true;
            else
                return false;
        }else
            return false;
    }
}