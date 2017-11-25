package com.newnham.app.GCSE_Latin.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.newnham.app.GCSE_Latin.R;

import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ENGLISH_TO_LATIN;

public class MainActivity2 extends AppCompatActivity {

    // Fields
    // ------
    Button mButtonNounPagerSelector;
    Button mButtonVerbPagerSelector;
    Button mButtonVerbGame;
    Button mButtonNounGame;
    Button mButtonNounEndingMenu;

    private String mTranslationDirection = ENGLISH_TO_LATIN;  // Default Setting


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
                Intent intent = VerbGameActivity.newIntent(MainActivity2.this);
                startActivity(intent);
            }
        });

        // Noun Game
        mButtonNounGame = (Button) findViewById(R.id.buttonNounGame);
        mButtonNounGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounGameActivity.newIntent(MainActivity2.this);
                startActivity(intent);
            }
        });

        // Verb Pager Selection
        mButtonVerbPagerSelector = (Button) findViewById(R.id.buttonVerbPagerSelection);
        mButtonVerbPagerSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = VerbPagerSelectionActivity.newIntent(MainActivity2.this);
                startActivity(intent);
            }
        });

        // Noun Pager Selection
        mButtonNounPagerSelector = (Button) findViewById(R.id.buttonNounPagerSelection);
        mButtonNounPagerSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerSelectionActivity.newIntent(MainActivity2.this);
                startActivity(intent);
            }
        });

        // Noun Ending Menu Selection
        mButtonNounEndingMenu = (Button) findViewById(R.id.buttonNounEndings);
        mButtonNounEndingMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounEndingMenuActivity.newIntent(MainActivity2.this);
                startActivity(intent);
            }
        });
    }




}
