package com.learzhu.browser.broadreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.learzhu.browser.activity.PopuWindowActivity;

public class ScreenBroadcastReceiver extends BroadcastReceiver {
    public ScreenBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String strAction = intent.getAction();
        if (Intent.ACTION_SCREEN_OFF.equals(strAction)) {
            //屏幕锁屏
            Log.i("screenBR", "屏幕锁屏：ACTION_SCREEN_OFF触发");
            Toast.makeText(context, "锁屏了", Toast.LENGTH_SHORT).show();
        } else if (Intent.ACTION_SCREEN_ON.equals(strAction)) {
            //屏幕解锁(实际测试效果，不能用这个来判断解锁屏幕事件)
            //【因为这个是解锁的时候触发，而解锁的时候广播还未注册】
            Log.i("screenBR", "屏幕解锁：ACTION_SCREEN_ON触发");
            Toast.makeText(context, "解锁了", Toast.LENGTH_SHORT).show();
            Intent alarmIntent = new Intent(context, PopuWindowActivity.class);
            alarmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(alarmIntent);
        } else if (Intent.ACTION_USER_PRESENT.equals(strAction)) {
            //屏幕解锁(该Action可以通过静态注册的方法注册)
            //在解锁之后触发的，广播已注册
            Log.i("screenBR", "屏幕解锁：ACTION_USER_PRESENT触发");
            Toast.makeText(context, "解锁了", Toast.LENGTH_SHORT).show();
            Intent alarmIntent = new Intent(context, PopuWindowActivity.class);
            alarmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(alarmIntent);
        } else {
            //nothing
        }
    }
}
