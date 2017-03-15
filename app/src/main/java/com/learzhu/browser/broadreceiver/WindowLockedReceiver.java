package com.learzhu.browser.broadreceiver;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.learzhu.browser.activity.PopuWindowActivity;

public class WindowLockedReceiver extends BroadcastReceiver {
    private static final String TAG = "WindowLockedReceiver";

    public WindowLockedReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
//        throw new UnsupportedOperationException("Not yet implemented");
        Log.d(TAG, intent.getAction());
        KeyguardManager km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        if (km.inKeyguardRestrictedInputMode() || intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            Intent alarmIntent = new Intent(context, PopuWindowActivity.class);
            alarmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(alarmIntent);
        }
    }


}
