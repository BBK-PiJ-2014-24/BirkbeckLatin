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
    Button mButtonVerbPager;
    Button mButtonVerbPagerSelector;
    Button mButtonVerbGame;
    Button mButtonNounGame;

    // OnCreate()
    // ----------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonVerbPager = (Button) findViewById(R.id.buttonPager);
        mButtonVerbPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = VerbPagerActivity.newIntent(MainActivity.this, 1);
                startActivity(intent);
            }
        });

        mButtonVerbGame = (Button) findViewById(R.id.buttonVerbGame);
        mButtonVerbGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = VerbGameActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });

        mButtonNounGame = (Button) findViewById(R.id.buttonNounGame);
        mButtonNounGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounGameActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });

        mButtonNounGame = (Button) findViewById(R.id.buttonVerbPagerSelection);
        mButtonNounGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = VerbPagerSelectionActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }




}
