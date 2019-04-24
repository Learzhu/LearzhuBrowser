package com.learzhu.browser.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.learzhu.browser.R;

import java.util.UUID;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {
    private static final String TAG = "Main3Activity";

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mProgressBar = (ProgressBar) findViewById(R.id.iv_loading);
        mProgressBar.postDelayed(new Runnable() {
            @Override
            public void run() {
//                finish();
                Log.i(TAG, "run: mProgressBar.getVisibility() " + mProgressBar.getVisibility());
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        }, 2000);
        Log.v(TAG, "onCreate--------+ time" + System.currentTimeMillis());
        View view = findViewById(R.id.back_view);
        view.bringToFront();
        Log.i(TAG, "onCreate: uuid 1" + UUID.randomUUID());
        Log.i(TAG, "onCreate: uuid 2" + UUID.randomUUID());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume--------+ time" + System.currentTimeMillis());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "onPause--------+ time" + System.currentTimeMillis());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "onStop--------+ time" + System.currentTimeMillis());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy--------+ time" + System.currentTimeMillis());
    }

    public void finish1() {
        finish();
        Log.v(TAG, "finish--------+ time" + System.currentTimeMillis());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.v(TAG, "onBackPressed--------+ time" + System.currentTimeMillis());
    }
}
