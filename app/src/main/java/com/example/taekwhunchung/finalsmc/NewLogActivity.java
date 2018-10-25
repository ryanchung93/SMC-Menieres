package com.example.taekwhunchung.finalsmc;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.MediaController;
import android.widget.Toolbar;
import android.widget.VideoView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewLogActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar myToolbar;

    CheckedTextView headacheCTV;
    CheckedTextView ringingCTV;
    CheckedTextView hearingLossCTV;
    CheckedTextView deafCTV;

    Button previewButton;
    Button submitButton;

    String videoURL;


    static final int REQUEST_VIDEO_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_log);


        myToolbar = findViewById(R.id.newLogToolbar);
        setSupportActionBar(myToolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

        headacheCTV = findViewById(R.id.headacheCheckedTextView);
        ringingCTV = findViewById(R.id.ringingCheckedTextView);
        hearingLossCTV = findViewById(R.id.hearingLossCheckedTextView);
        deafCTV = findViewById(R.id.deafCheckedTextView);

        submitButton = findViewById(R.id.submitButton);
        previewButton = findViewById(R.id.previewButton);


        setCheckBoxListener(headacheCTV);
        setCheckBoxListener(ringingCTV);
        setCheckBoxListener(hearingLossCTV);
        setCheckBoxListener(deafCTV);




    }

    public void dispatchTakeVideoIntent(View view) {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Log.i("check", "working");
            videoURL = intent.getDataString();

            Intent previewIntent = new Intent(getApplicationContext(), VideoPreviewActivity.class);
            previewIntent.putExtra("url", videoURL);
            startActivity(previewIntent);

        } else {
            Log.i("check", "not working");
        }


//
//                try {
//            MediaController mediacontroller = new MediaController(NewLogActivity.this);
//            mediacontroller.setAnchorView(videoView);
//            // Get the URL from String VideoURL
//            videoView.setMediaController(mediacontroller);
//            videoView.setVideoURI(videoUri);
//            videoView.start();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Intent intentToNext = new Intent(getApplicationContext(), ChooseSymptomActivity.class);
//
//
//        startActivity(intentToNext);

    }

    private void setCheckBoxListener(CheckedTextView ctv) {
        final CheckedTextView checkedTextView = ctv;
        checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkedTextView.isChecked()) {
                    checkedTextView.setChecked(false);
                } else {
                    checkedTextView.setChecked(true);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_new_log, menu);

        menu.findItem(R.id.action_profile).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                toProfileActivity();
                Log.i("icon clicked", "profile");
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

    public void preview(View view) {
        Intent intent = new Intent(getApplicationContext(), VideoPreviewActivity.class);

    }

    public void submitLog(View view) {
        Date c = Calendar.getInstance().getTime();
//        Log.i("time","Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("yyyy'년' MM'월' dd'일'");
        String formattedDate = df.format(c);
        Log.i("nowww", formattedDate);

        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("date", formattedDate);
        startActivity(intent);

    }

}
