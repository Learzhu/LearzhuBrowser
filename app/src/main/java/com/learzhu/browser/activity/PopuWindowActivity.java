package com.learzhu.browser.activity;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.learzhu.browser.R;
import com.learzhu.browser.utils.ScreenStatusUtil;
import com.learzhu.browser.utils.ToastUtil;

public class PopuWindowActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        final Window win = getWindow();
//        //分别是锁屏状态下显示，解锁，保持屏幕长亮，打开屏幕。
//        win.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
//                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
//                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
//                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        setContentView(R.layout.activity_popu_window);
        KeyguardManager km = (KeyguardManager) getApplicationContext().getSystemService(Context.KEYGUARD_SERVICE);
        if (km.inKeyguardRestrictedInputMode()) {
//            Intent alarmIntent = new Intent(context, PopuWindowActivity.class);
//            alarmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(alarmIntent);
        }

        if (!ScreenStatusUtil.isScreenLight(getApplicationContext())) {
            //当前黑屏（屏幕熄灭）
            ToastUtil.showShortToast(this, "熄灭");
        } else {
            ToastUtil.showShortToast(this, "亮屏");
        }
        findViewById(R.id.contail_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopuWindowActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
