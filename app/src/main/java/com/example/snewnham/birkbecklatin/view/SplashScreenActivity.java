package com.example.snewnham.birkbecklatin.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.snewnham.birkbecklatin.R;

/**
 * Created by snewnham on 26/03/2017.
 */

public class SplashScreenActivity extends AppCompatActivity {

    // OnCreate()
    // ----------

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);
        Thread thread = new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(3000);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);  // Send Intent on to MainActivity
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

}
