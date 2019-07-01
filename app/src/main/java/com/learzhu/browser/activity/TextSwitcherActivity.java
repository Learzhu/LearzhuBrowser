package com.learzhu.browser.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.learzhu.browser.R;
import com.learzhu.browser.textswitcher.TextSwitcherAnimation;

import java.util.ArrayList;
import java.util.List;

/**
 * TextSwitcherActivity.java是LearzhuBrowser的TextSwitcher的demo类。
 *
 * @author Learzhu
 * @version 1.0.0 2019-07-01 17:54
 * @use
 * @update UserName 2019-07-01 17:54
 * @updateDes
 */

public class TextSwitcherActivity extends AppCompatActivity {
    TextSwitcher switcher;
    List<String> texts;
    private int marker;


    public static void actionStart(Context context) {
        Intent intent = new Intent(context, TextSwitcherActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_switcher);
        switcher = findViewById(R.id.textswitcher);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return new TextView(TextSwitcherActivity.this);
            }
        });
        texts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            texts.add("循环------" + i);
        }
        switcher.setText(texts.get(0));
//        switcher.setInAnimation();
//        switcher.setOutAnimation();
        new TextSwitcherAnimation(switcher, texts).create();
    }

    private Handler handler = new Handler();
    private Runnable task = new Runnable() {
        @Override
        public void run() {
            marker = ++marker % texts.size();
            switcher.setText(texts.get(marker));
            handler.postDelayed(task, 4000);
        }
    };


}
