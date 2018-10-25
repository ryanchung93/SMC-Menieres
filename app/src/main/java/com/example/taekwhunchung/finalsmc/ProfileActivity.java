package com.example.taekwhunchung.finalsmc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> logs = new ArrayList<String>();
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        listView = findViewById(R.id.listView);
        toolbar = findViewById(R.id.profileToolBar);

        setSupportActionBar(toolbar);

        if(getIntent().getStringExtra("date") == null) {
            logs.add("no data");
        } else {
            logs.add(getIntent().getStringExtra("date"));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, logs);
        listView.setAdapter(arrayAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_landing, menu);

        menu.findItem(R.id.action_profile).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
//                toProfileActivity();
                Log.i("icon clicked", "profile");
                toProfileActivity();
                return true;
            }
        });

        menu.findItem((R.id.new_log)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Log.i("icon clicked", "new log");
                makeNewLog();
//                makeNewLog(frameLayout);
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

    public void makeNewLog() {
        Intent intent = new Intent(getApplicationContext(), NewLogActivity.class);
        startActivity(intent);
    }

}
