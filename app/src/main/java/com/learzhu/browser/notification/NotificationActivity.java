package com.learzhu.browser.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;

import com.learzhu.browser.R;
import com.learzhu.browser.glide.GlideActivity;

import static android.app.Notification.VISIBILITY_SECRET;

public class NotificationActivity extends AppCompatActivity {
    public static final String NOTIFY_CHANNEL_ID = "com.learzhu.browser";

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, NotificationActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        testNormalNotification();
    }

    private void testNormalNotification() {
        // 创建一个NotificationManager的引用
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        //处理点击Notification的逻辑
        Intent resultIntent = new Intent(this, GlideActivity.class);
//        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  //添加为栈顶Activity
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        resultIntent.putExtra("what", 5);

        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 5, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //android 8.0以上需要特殊处理，也就是targetSDKVersion为26以上
            notificationManager.createNotificationChannel(createNotificationChannel());
            Notification.Builder builder = new Notification.Builder(this.getApplicationContext(), NOTIFY_CHANNEL_ID)
                    .setSound(Settings.System.DEFAULT_RINGTONE_URI)
                    .setSmallIcon(R.mipmap.ic_launcher)                                         //设置通知的图标
                    .setTicker("有新消息呢")                                                     //设置状态栏的标题
                    .setContentTitle("这个是标题")                                               //设置标题
                    .setContentText("这个是内容")                                                //消息内容
                    .setDefaults(Notification.DEFAULT_ALL)                                      //设置默认的提示音
//                .setPriority(Notification.PRIORITY_DEFAULT)                                 //设置该通知的优先级
                    .setOngoing(false)                                                          //让通知左右滑的时候不能取消通知
                    .setWhen(System.currentTimeMillis())                                        //设置通知时间，默认为系统发出通知的时间，通常不用设置
                    .setAutoCancel(true)
                    .setContentIntent(resultPendingIntent)
                    .setAutoCancel(true);
            Notification notification = builder.build();
            notification.flags = (Notification.FLAG_AUTO_CANCEL | notification.flags);
            notificationManager.notify(1, notification);
        } else {
            // 定义Notification的各种属性
            Notification.Builder builder = new Notification.Builder(this.getApplicationContext())
                    .setSound(Settings.System.DEFAULT_RINGTONE_URI)
                    .setSmallIcon(R.mipmap.ic_launcher)                                         //设置通知的图标
                    .setTicker("有新消息呢")                                                     //设置状态栏的标题
                    .setContentTitle("这个是标题")                                               //设置标题
                    .setContentText("这个是内容")                                                //消息内容
                    .setDefaults(Notification.DEFAULT_ALL)                                      //设置默认的提示音
//                .setPriority(Notification.PRIORITY_DEFAULT)                                 //设置该通知的优先级
                    .setOngoing(false)                                                          //让通知左右滑的时候不能取消通知
                    .setWhen(System.currentTimeMillis())                                        //设置通知时间，默认为系统发出通知的时间，通常不用设置
                    .setAutoCancel(true);                                                       //打开程序后图标消失

            builder.setContentIntent(resultPendingIntent);
            //发送
//        notificationManager.notify(1, builder.build());
            notificationManager.notify(1, builder.getNotification());
            //结束广播
//        notificationManager.cancel(1);
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private NotificationChannel createNotificationChannel() {
        NotificationChannel channel = new NotificationChannel(NOTIFY_CHANNEL_ID, this.getString(R.string.app_name), NotificationManager.IMPORTANCE_DEFAULT);
        channel.canBypassDnd();//是否绕过请勿打扰模式
        channel.enableLights(true);//闪光灯
        channel.setLockscreenVisibility(VISIBILITY_SECRET);//锁屏显示通知
        channel.setLightColor(Color.RED);//闪关灯的灯光颜色
        channel.canShowBadge();//桌面launcher的消息角标
        channel.enableVibration(true);//是否允许震动
        channel.getAudioAttributes();//获取系统通知响铃声音的配置
        channel.getGroup();//获取通知取到组
        channel.setBypassDnd(true);//设置可绕过 请勿打扰模式
        channel.setVibrationPattern(new long[]{100, 100, 200});//设置震动模式
        channel.shouldShowLights();//是否会有灯光
//        getManager().createNotificationChannel(channel);
        return channel;
    }
}
