package com.example.taekwhunchung.finalsmc;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class LandingActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private TabLayout tabLayout;

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;

    private android.support.v7.widget.Toolbar myToolbar;

    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);


        myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);


        floatingActionButton = findViewById(R.id.floatingActionButton);

        frameLayout = findViewById(R.id.frameLayout);
        tabLayout = findViewById(R.id.tabLayout);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();

        setFragment(firstFragment);

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i("tab position", Integer.toString(tab.getPosition()));
                switch (tab.getPosition()) {
                    case 0:
                        setFragment(firstFragment);
                        break;
                    case 1:
                        setFragment(secondFragment);
                        break;
                    case 2:
                        setFragment(thirdFragment);
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_landing, menu);

        menu.findItem(R.id.action_profile).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                toProfileActivity();
                Log.i("icon clicked", "profile");
                return true;
            }
        });

        menu.findItem((R.id.new_log)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Log.i("icon clicked", "new log");
                makeNewLog(frameLayout);
                return true;
            }
        });

        menu.findItem(R.id.action_home).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Log.i("icon clicked", "home");
                toHome();
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }



    public void toHome() {
        Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
        startActivity(intent);
    }

    public void toProfileActivity() {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
    }

    public void makeNewLog(View view) {
        Intent intent = new Intent(getApplicationContext(), NewLogActivity.class);
        startActivity(intent);
    }
}
