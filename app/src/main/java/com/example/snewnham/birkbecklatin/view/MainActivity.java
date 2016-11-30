package com.example.snewnham.birkbecklatin.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.snewnham.birkbecklatin.R;

public class MainActivity extends AppCompatActivity {

    // Fields
    // ------
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = VerbPagerActivity.newIntent(MainActivity.this, 1);
                startActivity(intent);
            }
        });


    }




}
