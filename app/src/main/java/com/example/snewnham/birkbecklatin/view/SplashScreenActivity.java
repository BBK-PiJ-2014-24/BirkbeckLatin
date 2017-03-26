package com.example.snewnham.birkbecklatin.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by snewnham on 26/03/2017.
 */

public class SplashScreenActivity extends AppCompatActivity {

    // OnCreate()
    // ----------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, MainActivity.class);  // Send Intent on to MainActivity
        startActivity(intent);
    }

}
