package com.learzhu.browser.activity;

import android.app.FragmentTransaction;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.igexin.sdk.PushManager;
import com.learzhu.browser.BuildConfig;
import com.learzhu.browser.R;
import com.learzhu.browser.broadreceiver.ScreenBroadcastReceiver;
import com.learzhu.browser.fragment.BlankFragment;
import com.learzhu.browser.getui.GeTuiIntentService;
import com.learzhu.browser.getui.GetuiPushService;
import com.learzhu.browser.getui.PushMsg;
import com.learzhu.browser.utils.AppUtils;
import com.learzhu.browser.utils.LogUtils;
import com.learzhu.browser.utils.ObjectUtils;
import com.learzhu.browser.utils.StatusBarUtil;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {
    private static final String TAG = "MainActivity";
    private ScreenBroadcastReceiver screenBroadcastReceiver = null;
    private Context mContext = null;
    private Button lockedScreenBtn = null;
    private android.support.v4.app.FragmentTransaction mFragmentTransaction1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusTranslucent(this);
        setContentView(R.layout.activity_main);
        initGeTui();
//        mContext = getApplicationContext();
        mContext = this;
        registerScreenBroadcastReceiver();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mFragmentTransaction1 = getSupportFragmentManager().beginTransaction();
//        MainActivityFragment mainActivityFragment = new MainActivityFragment();

//        BlankFragment blankFragment = new BlankFragment();
//        mFragmentTransaction1.add(R.id.fragment, blankFragment);
//        mFragmentTransaction1.commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
//                changeStatusBarFragment();
//                GlideActivity.actionStart(mContext);
//                NotificationActivity.actionStart(MainActivity.this);
//                RecyclerViewHorizontalActivity.actionStart(mContext);
                PushMsg pushMsg = new PushMsg();
                pushMsg.setSendType("11");
                pushMsg.setContent("透传测试");
                showNotification(MainActivity.this, (int) System.currentTimeMillis(), pushMsg);
            }
        });
    }

    private void changeStatusBarFragment() {
        StatusBarUtil.setStatusByColor(MainActivity.this, Color.BLACK);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        ItemFragment fragment = ItemFragment.newInstance(5);
//                fragmentTransaction.replace(R.id.fragment, fragment);
//                mFragmentTransaction1.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PowerManager pm = (PowerManager) this.getSystemService(Context.POWER_SERVICE);
//        if (!pm.isScreenOn()) {
//            PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP |
//                    PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "bright");
//            wl.acquire();
//            wl.release();
//        }
    }

    /**
     * ACTION_SCREEN_ON和ACTION_SCREEN_OFF还有ACTION_USER_PRESENT三个Action的用法，
     * 由于作为一个总结博文，当时并没有详细讲， ACTION_SCREEN_ON和ACTION_SCREEN_OFF
     * 只能通过动态注册的方式（代码内context.register和unregister），
     * 而ACTION_USER_PRESENT则是动态、静态注册两种方式都可以。
     */
    private void registerScreenBroadcastReceiver() {
        screenBroadcastReceiver = new ScreenBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);//当屏幕锁屏的时候触发
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);//当屏幕解锁的时候触发
        intentFilter.addAction(Intent.ACTION_USER_PRESENT);//当用户重新唤醒手持设备时触发
        mContext.registerReceiver(screenBroadcastReceiver, intentFilter);
        Log.i("screenBR", "screenBroadcastReceiver注册了");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void initGeTui() {
        PushManager.getInstance().initialize(this.getApplicationContext(), GetuiPushService.class);
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), GeTuiIntentService.class);
    }

    /**
     * 显示通知
     *
     * @param context        上下文
     * @param notificationId 推送id
     * @param pushMsg        推送消息
     */
    private void showNotification(Context context, int notificationId, PushMsg pushMsg) {
        String title = "未知类型";
        String sendType = pushMsg.getSendType();
        PendingIntent pendingIntent = null;
        Intent intent = null;
        String content = pushMsg.getContent();
        if (AppUtils.isAppRunning(context, BuildConfig.APPLICATION_ID)) {//如果app在前台进行,并且已经登录
            intent = new Intent(context, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);//关键的一步，设置启动模式
        } else {
            intent = new Intent(context, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);//关键的一步，设置启动模式
        }
        if (ObjectUtils.isObjectNotNull(intent)) {
            pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        }
        showNotification(context, notificationId, title, content, pendingIntent);
    }

    public static int NOTIFIID = 0;//全局静态变量 标志通知id

    /**
     * 展示通知
     *
     * @param context        上下文
     * @param notificationId 通知id
     * @param title          标题
     * @param content        内容
     * @param pendingIntent  动作
     */
    private void showNotification(Context context, int notificationId, String title, String content, PendingIntent pendingIntent) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.push)
                        .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.push))
                        .setContentTitle(title)
                        .setContentText(content);
        if (ObjectUtils.isObjectNotNull(pendingIntent)) {
            mBuilder.setContentIntent(pendingIntent);
        }
//        boolean music = SPUtils.getInstance(SettingActivity.SETTING_SP).getBoolean(SettingActivity.SETTING_MUSIC, true);
//        boolean vibrate = SPUtils.getInstance(SettingActivity.SETTING_SP).getBoolean(SettingActivity.SETTING_VIBRATE, true);

//        if (music && vibrate) {
//            mBuilder.setDefaults(Notification.DEFAULT_ALL);
//        } else {
//            if (vibrate && !music) {//如果震动并且不响铃的话
//                mBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
//            } else if (!vibrate && music) {//如果响铃不振动的话
//                mBuilder.setDefaults(Notification.DEFAULT_SOUND);
//            } else {//不响铃 不振动的情况
//                mBuilder.setDefaults(Notification.DEFAULT_LIGHTS);//那就仅仅设置灯光咯
//            }
//        }


        NotificationManager mNotificationManager =
                (NotificationManager) context.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = mBuilder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        notificationId = notificationId + (NOTIFIID++);
        LogUtils.e(TAG, "showNotification: notificationId:" + notificationId);
        mNotificationManager.notify(notificationId, notification);
    }


}
