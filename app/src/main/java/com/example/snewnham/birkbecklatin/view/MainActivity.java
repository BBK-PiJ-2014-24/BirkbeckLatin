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
    Button mButtonNounPagerSelector;
    Button mButtonVerbPagerSelector;
    Button mButtonVerbGame;
    Button mButtonNounGame;

    // OnCreate()
    // ----------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Verb Game
        mButtonVerbGame = (Button) findViewById(R.id.buttonVerbGame);
        mButtonVerbGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = VerbGameActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });

        // Noun Game
        mButtonNounGame = (Button) findViewById(R.id.buttonNounGame);
        mButtonNounGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounGameActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });

        // Verb Pager Selection
        mButtonVerbPagerSelector = (Button) findViewById(R.id.buttonVerbPagerSelection);
        mButtonVerbPagerSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = VerbPagerSelectionActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });

        // Noun Pager Selection
        mButtonNounPagerSelector = (Button) findViewById(R.id.buttonNounPagerSelection);
        mButtonNounPagerSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerSelectionActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }




}
