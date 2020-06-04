package com.learzhu.browser.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import java.util.concurrent.atomic.AtomicInteger;

import static android.app.Notification.VISIBILITY_PUBLIC;
import static android.content.Context.NOTIFICATION_SERVICE;
import static android.support.v4.app.NotificationCompat.BADGE_ICON_SMALL;

/**
 * NotificationUtil.java是 LearzhuBrowser的通知的工具类。
 *
 * @author Learzhu
 * @version 1.1.0 2020-04-29 11:39
 * @update Learzhu 2020-04-29 11:39
 * @updateDes
 * @include {@link }
 * @used {@link }
 * @goto {@link }
 */
public class NotificationUtil {
    /**
     * @description: 用于保存一个APP内唯一的NotificationId 的方法
     * @author: Learzhu
     * @date: Create in    2020-04-29 15:22
     * @param null:
     * @return:
     */
    private final static AtomicInteger mAtomicNotificationId = new AtomicInteger(0);

    public static int getNotificationId() {
        return mAtomicNotificationId.incrementAndGet();
    }

    public static void createAndShowNotification(Context context, String groupId, String groupName,
                                                 String channelId, String channelName,
                                                 PendingIntent pendingIntent,
                                                 int largeIconResId, int smallIconResId,
                                                 String title, String content) {
        createAndShowNotification(context, groupId, groupName, channelId, channelName, pendingIntent, largeIconResId, smallIconResId, null
                , title, content, Notification.DEFAULT_ALL, false);
    }

    public static void createAndShowNotification(Context context, String groupId, String groupName,
                                                 String channelId, String channelName,
                                                 PendingIntent pendingIntent,
                                                 int largeIconResId, int smallIconResId,
                                                 String tickerText, String title, String content) {
        createAndShowNotification(context, groupId, groupName, channelId, channelName, pendingIntent, largeIconResId, smallIconResId, tickerText
                , title, content, Notification.DEFAULT_ALL, false);
    }

    /**
     * @param context:        上下文
     * @param groupId:        通知渠道组ID
     * @param groupName:      通知渠道组名称
     * @param channelId:      通知渠道ID
     * @param channelName:    通知渠道名称
     * @param pendingIntent:  点击通知的跳转
     * @param largeIconResId: 通知大图标
     * @param smallIconResId: 通知小图标
     * @param tickerText:     ticker text 则是状态栏非下拉展示时，在状态栏显示1~2秒的提示文字。
     *                        状态栏摘要(ticker)  在 api 21 后不再显示，仅用于辅助服务。
     * @param title:          通知标题
     * @param content:        通知内容
     * @param defaults:       默认通知的 声音 显示 指示灯
     * @param onlyVibrate:    只展示 静音模式
     * @description: 创建兼容android O通知的方法
     * @author: Learzhu
     * @date: Create in    2020-04-30 09:24
     * @return: void
     */
    public static void createAndShowNotification(Context context, String groupId, String groupName,
                                                 String channelId, String channelName,
                                                 PendingIntent pendingIntent,
                                                 int largeIconResId, int smallIconResId,
                                                 String tickerText, String title, String content,
                                                 int defaults, boolean onlyVibrate) {
        NotificationCompat.Builder builder = null;
        //创建通知栏管理对象
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        if (null != notificationManager) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                //android 8.0之后新增通知渠道
                if (null != groupId && null != groupName) {
                    //创建一个渠道组
                    NotificationChannelGroup group = new NotificationChannelGroup(groupId, groupName);
                    notificationManager.createNotificationChannelGroup(group);
                }
                //创建渠道
                notificationManager.createNotificationChannel(createNotificationChannel(channelId, channelName));
                builder = new NotificationCompat.Builder(context, channelId);
                builder.setBadgeIconType(BADGE_ICON_SMALL);//设置显示角标的样式
                builder.setNumber(3);//设置显示角标的数量
                builder.setTimeoutAfter(5000);//设置通知被创建多长时间之后自动取消通知栏的通知。
//            } else if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {//android 3.0基本不存在别的更小版本手机
            } else {
                builder = new NotificationCompat.Builder(context);
            }
            //以下为通知具体内容
            //setContentTitle 通知栏通知的标题
            builder.setContentTitle(title);
            //setContentText  通知栏通知的详细内容
            builder.setContentText(content);
            //setAutoCancel 点击通知的清除按钮是否清除该消息（true/false）
            builder.setAutoCancel(true);
            //setLargeIcon  通知消息上的大图标
            //builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher));
            builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), largeIconResId));
            //setSmallIcon  通知上面的小图标
            builder.setSmallIcon(smallIconResId);//小图标
//            //创建一个意图
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com"));
//            PendingIntent pIntent = PendingIntent.getActivity(this, 1, intent, 0);
            //setContentIntent  将意图设置到通知上
            builder.setContentIntent(pendingIntent);
            //设置通知指示灯 颜色闪动频率
            builder.setLights(-16711936, 300, 1000);
            //通知默认的声音 震动 呼吸灯
//            builder.setDefaults(NotificationCompat.DEFAULT_ALL);
            if (onlyVibrate) {
                //是否设置了静音模式
                defaults &= Notification.DEFAULT_VIBRATE;
            }
            builder.setDefaults(defaults);
            builder.setTicker(tickerText == null ? "" : tickerText);
            //构建通知
            Notification notification = builder.build();
//            notification.flags = (Notification.FLAG_SHOW_LIGHTS | notification.flags);  //该方法无效
            notification.defaults |= Notification.FLAG_SHOW_LIGHTS;
            notification.defaults |= Notification.FLAG_AUTO_CANCEL;
            //将构建好的通知添加到通知管理器中，执行通知
            notificationManager.notify(getNotificationId(), notification);
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    public static NotificationChannel createNotificationChannel(String channelId, String channelName) {
        return createNotificationChannel(channelId, channelName, Notification.DEFAULT_VIBRATE);
    }

    /**
     * @param channelId:   渠道通知ID
     * @param channelName: 渠道名称
     * @param importance:  渠道优先级
     * @description: 兼容android O 以及更高版本的创建渠道通知的方法
     * @author: Learzhu
     * @date: Create in    2020-04-29 13:21
     * @return: android.app.NotificationChannel
     */
    @TargetApi(Build.VERSION_CODES.O)
    public static NotificationChannel createNotificationChannel(String channelId, String channelName, int importance) {
        NotificationChannel channel = new NotificationChannel(
                channelId, //通知渠道ID
                channelName, //通知渠道名称
                importance); //通知渠道安全等级
        channel.enableLights(true);// //设置开启指示灯，如果设备有的话
        channel.setLightColor(Color.RED);//设置指示灯颜色
        channel.setLockscreenVisibility(VISIBILITY_PUBLIC);//设置是否应在锁定屏幕上显示此频道的通知
        channel.canShowBadge();//桌面launcher的消息角标 设置是否显示角标
        channel.enableVibration(true);//是否允许震动
        channel.setBypassDnd(true);//设置可绕过 请勿打扰模式
        channel.shouldShowLights();//是否会有灯光
//        channel.setVibrationPattern(new long[]{100, 100, 200});//设置震动模式 设置震动频率
        channel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 600});//设置震动模式 设置震动频率

        channel.canBypassDnd();//是否绕过请勿打扰模式
        channel.getAudioAttributes();//获取系统通知响铃声音的配置
        channel.getGroup();//获取通知取到组
//        getManager().createNotificationChannel(channel);
        return channel;
    }
}
