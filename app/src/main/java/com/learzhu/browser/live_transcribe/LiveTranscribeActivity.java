package com.learzhu.browser.live_transcribe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.learzhu.browser.R;

public class LiveTranscribeActivity extends AppCompatActivity {

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, LiveTranscribeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_transcribe);
    }
}
