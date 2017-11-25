package com.newnham.app.GCSE_Latin.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;
import com.newnham.app.GCSE_Latin.R;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.TRANSLATION_DIRECTION;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // Fields
    // ------
    Button mButtonNounPagerSelector;
    Button mButtonVerbPagerSelector;
    Button mButtonVerbGame;
    Button mButtonNounGame;
    Button mButtonNounEndingMenu;

    Context context;   // arguments for toasts
    int duration = Toast.LENGTH_SHORT;
    String translation = " Translation";



    // OnCreate()
    // ----------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


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

        // Noun Ending Selection
        mButtonNounEndingMenu = (Button) findViewById(R.id.buttonNounEndings);
        mButtonNounEndingMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounEndingMenuActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        this.startActivity(new Intent(this, MainActivity.class));
    }



    // onCreateOptionsMenu() - Inflate ActionBar Menu
    // ---------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    // onOptionsItemSelected() - Item List for Menu
    // ---------------------
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        context = getApplicationContext();
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(context);

        int id = item.getItemId();
        if (id == R.id.english_to_latin) {
            databaseAccess.sqlMeta_Insertion(TRANSLATION_DIRECTION, 0);  //  mTranslationDirection = ENGLISH_TO_LATIN ;
            Toast toast = Toast.makeText(context, getString(R.string.english_to_latin) + translation, duration);
            toast.show();
        } else {
            databaseAccess.sqlMeta_Insertion(TRANSLATION_DIRECTION, 1);  //    mTranslationDirection = LATIN_TO_ENGLISH;
            Toast toast = Toast.makeText(context, getString(R.string.latin_to_english) + translation, duration);
            toast.show();
        }
        return super.onOptionsItemSelected(item);
    }

    // @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        context = getApplicationContext();
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(context);

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_english_to_latin) {
            databaseAccess.sqlMeta_Insertion(TRANSLATION_DIRECTION, 0);  //  mTranslationDirection = ENGLISH_TO_LATIN ;
            Toast toast = Toast.makeText(context, getString(R.string.english_to_latin) + translation, duration);
            toast.show();
        } else if (id == R.id.nav_latin_to_english) {
            databaseAccess.sqlMeta_Insertion(TRANSLATION_DIRECTION, 1);  //    mTranslationDirection = LATIN_TO_ENGLISH;
            Toast toast = Toast.makeText(context, getString(R.string.latin_to_english) + translation, duration);
            toast.show();
        } else if (id == R.id.nav_reset) {    // Reset
            databaseAccess.sqlMeta_Reset();
            Toast toast = Toast.makeText(context, R.string.resetDefault, duration);
            toast.show();
        } else if (id == R.id.nav_about) {    // Launch About Page
            Intent intent = AboutActivity.newIntent(MainActivity.this);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
