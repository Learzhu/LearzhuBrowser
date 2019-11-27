package com.learzhu.browser.service;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.util.Log;

/**
 * CustomJobIntentService.java是液多多的类。
 *
 * @author Learzhu
 * @version 2019-11-27 14:45
 * @update Learzhu 2019-11-27 14:45
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class CustomJobIntentService extends JobIntentService {
    private static final String TAG = "CustomJobIntentService";
    public static final int JOB_ID = 1;

    public static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, CustomJobIntentService.class, JOB_ID, work);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        // 具体逻辑
        String data = intent.getStringExtra("data");
        Log.i(TAG, "onHandleWork:  data: " + data);
    }

}
