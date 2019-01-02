package com.learzhu.browser.activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.learzhu.browser.R;

import java.util.ArrayList;

public class AsyncTaskActivity extends AppCompatActivity {
    private static final String TAG = "AsyncTaskActivity";

    private TestTask mTestTask;

    /**
     * 售后订单列表的界面
     *
     * @param context 上下文
     */
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, AsyncTaskActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        load();
        findViewById(R.id.reload_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reload();
            }
        });
    }

    private class TestTask extends AsyncTask<Intent, Void, Long> {
        ArrayList<Integer> mArrayList = new ArrayList<>();

        public TestTask() {
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.e(TAG, "onPostExecute");
        }

        @Override
        protected Long doInBackground(Intent... intents) {
            Log.e(TAG, "doInBackground: ");
            for (int i = 0; i < 10000; i++) {
                mArrayList.add(i);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            Log.e(TAG, "onPostExecute: ");
            if (mArrayList.size() == 10000) {
                System.out.println("sccuss");
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }

    public synchronized void load() {
        try {
            if (mTestTask == null) {
                mTestTask = new TestTask();
            }
            mTestTask.execute();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "load: error: " + e);
        }
    }

    /**
     * 重新加载
     */
    public void reload() {
        try {
            stop();
            load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            if (mTestTask != null && !mTestTask.isCancelled()) {
                mTestTask.cancel(true);
                mTestTask = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
