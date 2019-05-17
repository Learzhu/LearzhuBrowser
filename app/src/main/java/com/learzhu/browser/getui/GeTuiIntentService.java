package com.learzhu.browser.getui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;

import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.message.BindAliasCmdMessage;
import com.igexin.sdk.message.FeedbackCmdMessage;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.igexin.sdk.message.SetTagCmdMessage;
import com.igexin.sdk.message.UnBindAliasCmdMessage;
import com.learzhu.browser.BuildConfig;
import com.learzhu.browser.R;
import com.learzhu.browser.activity.MainActivity;
import com.learzhu.browser.test.json.JacksonJsonUtil;
import com.learzhu.browser.utils.AppUtils;
import com.learzhu.browser.utils.LogUtils;
import com.learzhu.browser.utils.ObjectUtils;

import java.io.IOException;

/**
 * 继承 GTIntentService 接收来自个推的消息, 所有消息在线程中回调, 如果注册了该服务, 则务必要在 AndroidManifest中声明, 否则无法接受消息<br>
 * onReceiveMessageData 处理透传消息<br>
 * onReceiveClientId 接收 cid <br>
 * onReceiveOnlineState cid 离线上线通知 <br>
 * onReceiveCommandResult 各种事件处理回执 <br>
 */
public class GeTuiIntentService extends GTIntentService {
    /**
     * 为了观察透传数据变化.
     */
    private static int cnt;

    public GeTuiIntentService() {
    }

    @Override
    public void onReceiveServicePid(Context context, int pid) {
    }

    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        // 透传消息的处理，详看SDK demo
        String appid = msg.getAppid();
        String taskid = msg.getTaskId();
        String messageid = msg.getMessageId();
        byte[] payload = msg.getPayload();
        String pkg = msg.getPkgName();
        String cid = msg.getClientId();
        // 第三方回执调用接口，actionid范围为90000-90999，可根据业务场景执行
        boolean result = PushManager.getInstance().sendFeedbackMessage(context, taskid, messageid, 90001);
        Log.d(TAG, "call sendFeedbackMessage = " + (result ? "success" : "failed"));

        Log.d(TAG, "onReceiveMessageData -> " + "appid = " + appid + "\ntaskid = " + taskid + "\nmessageid = " + messageid + "\npkg = " + pkg
                + "\ncid = " + cid);

        if (payload == null) {
            Log.e(TAG, "receiver payload = null");
        } else {
            String data = new String(payload);
            Log.d(TAG, "receiver payload = " + data);

            // 测试消息为了观察数据变化
            if (data.equals(getResources().getString(R.string.push_transmission_data))) {
                data = data + "-" + cnt;
                cnt++;
            }
//            sendMessage(data, 0);
            if (!TextUtils.isEmpty(data)) {
                try {
                    PushMsg pushMsg = JacksonJsonUtil.json2pojo(data, PushMsg.class);
                    if (ObjectUtils.isObjectNotNull(pushMsg)) {
                        LogUtils.e(TAG, "pushMsg: 不为空");
                        showNotification(context, (int) System.currentTimeMillis(), pushMsg);
                    } else {
                        LogUtils.e(TAG, "pushMsg: 为空");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Log.d(TAG, "----------------------------------------------------------------------------------------------");
        Log.e(TAG, "----------------------------------------------------------------------------------------------");
    }

    @Override
    public void onReceiveClientId(Context context, String clientid) {
        Log.e(TAG, "onReceiveClientId -> " + "clientid = " + clientid);
    }

    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
    }

    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
        Log.d(TAG, "onReceiveCommandResult -> " + cmdMessage);
        int action = cmdMessage.getAction();
        if (action == PushConsts.SET_TAG_RESULT) {
            setTagResult((SetTagCmdMessage) cmdMessage);
        } else if (action == PushConsts.BIND_ALIAS_RESULT) {
            bindAliasResult((BindAliasCmdMessage) cmdMessage);
        } else if (action == PushConsts.UNBIND_ALIAS_RESULT) {
            unbindAliasResult((UnBindAliasCmdMessage) cmdMessage);
        } else if ((action == PushConsts.THIRDPART_FEEDBACK)) {
            feedbackResult((FeedbackCmdMessage) cmdMessage);
        }
    }

    @Override
    public void onNotificationMessageArrived(Context context, GTNotificationMessage msg) {
    }

    @Override
    public void onNotificationMessageClicked(Context context, GTNotificationMessage msg) {
    }

    private void sendMessage(String data, int what) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.obj = data;
//        DemoApplication.sendMessage(msg);
    }

    /**
     * 显示通知
     *
     * @param context        上下文
     * @param notificationId 推送id
     * @param pushMsg        推送消息
     */
    private void showNotification(Context context, int notificationId, PushMsg pushMsg) {
        String title = "个推个人测试";
        String sendType = pushMsg.getSendType();
        PendingIntent pendingIntent = null;
        Intent intent = null;
        String content = pushMsg.getContent();
        if (AppUtils.isAppRunning(context, BuildConfig.APPLICATION_ID)) {//如果app在前台进行,并且已经登录
//            if (YZHApp.isAlreadyLoggedIn()) {
//                if (Constant.PUSH_TYPE.LOGIN_UPDATE_PASSWORD.equals(sendType)) {
//                    title = "登录密码";
//                    MainActivity.sendLoginPwdChangedEvent();
//                } else if (Constant.PUSH_TYPE.ADVERT_CHECK_UNPASS.equals(sendType)) {
//                    title = "广告审核未通过";
//                    intent = new Intent(context, ApplyFailedActivity.class);
//                } else if (Constant.PUSH_TYPE.ADVERT_BACK_CAPTIAL.equals(sendType)) {
//                    title = "广告液豆退回";
//                    intent = new Intent(context, ApplyFailedActivity.class);
//                } else if (Constant.PUSH_TYPE.ADVERT_CHECK.equals(sendType)) {
//                    title = "广告审核";
//                    intent = new Intent(context, ApplyFailedActivity.class);
//                } else if (Constant.PUSH_TYPE.ADVERT_BACK_MONEY.equals(sendType)) {
//                    title = "广告费用退回";
//                    intent = new Intent(context, ApplyFailedActivity.class);
//                }
//            } else {
//                intent = new Intent(context, LoginAndRegisterActivity.class);
//                intent.putExtra("comeType", LoginAndRegisterActivity.TYPE_LOGIN);
//            }
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
     *                       todo 魅族 华为等手机的通知需要自定义否则会异常
     *                       https://github.com/android-cn/android-discuss/issues/347
     */
    private void showNotification(Context context, int notificationId, String title, String content, PendingIntent pendingIntent) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.push)
                        .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.push))
                        .setContentTitle(title)
                        .setContentText(content);
        // 定义Notification的各种属性
//        Notification.Builder mBuilder = new Notification.Builder(this.getApplicationContext())
//                .setSound(android.provider.Settings.System.DEFAULT_NOTIFICATION_URI)        //
//                .setSmallIcon(R.drawable.push)                                         //设置通知的图标
//                .setTicker("有新消息呢")                                                     //设置状态栏的标题
//                .setContentTitle("这个是标题")                                               //设置标题
//                .setContentText("这个是内容")                                                //消息内容
//                .setDefaults(Notification.DEFAULT_ALL)                                      //设置默认的提示音
//                .setOngoing(false)                                                          //让通知左右滑的时候不能取消通知
//                .setWhen(System.currentTimeMillis())                                        //设置通知时间，默认为系统发出通知的时间，通常不用设置
//                .setAutoCancel(true);

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
        Notification notification = mBuilder.getNotification();
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        notificationId = notificationId + (NOTIFIID++);
        LogUtils.e(TAG, "showNotification: notificationId:" + notificationId);
        mNotificationManager.notify(notificationId, notification);
    }

    private void setTagResult(SetTagCmdMessage setTagCmdMsg) {
        String sn = setTagCmdMsg.getSn();
        String code = setTagCmdMsg.getCode();

        int text = R.string.add_tag_unknown_exception;
        switch (Integer.valueOf(code)) {
            case PushConsts.SETTAG_SUCCESS:
                text = R.string.add_tag_success;
                break;

            case PushConsts.SETTAG_ERROR_COUNT:
                text = R.string.add_tag_error_count;
                break;

            case PushConsts.SETTAG_ERROR_FREQUENCY:
                text = R.string.add_tag_error_frequency;
                break;

            case PushConsts.SETTAG_ERROR_REPEAT:
                text = R.string.add_tag_error_repeat;
                break;

            case PushConsts.SETTAG_ERROR_UNBIND:
                text = R.string.add_tag_error_unbind;
                break;

            case PushConsts.SETTAG_ERROR_EXCEPTION:
                text = R.string.add_tag_unknown_exception;
                break;

            case PushConsts.SETTAG_ERROR_NULL:
                text = R.string.add_tag_error_null;
                break;

            case PushConsts.SETTAG_NOTONLINE:
                text = R.string.add_tag_error_not_online;
                break;

            case PushConsts.SETTAG_IN_BLACKLIST:
                text = R.string.add_tag_error_black_list;
                break;

            case PushConsts.SETTAG_NUM_EXCEED:
                text = R.string.add_tag_error_exceed;
                break;

            default:
                break;
        }

        Log.d(TAG, "settag result sn = " + sn + ", code = " + code + ", text = " + getResources().getString(text));
    }

    private void bindAliasResult(BindAliasCmdMessage bindAliasCmdMessage) {
        String sn = bindAliasCmdMessage.getSn();
        String code = bindAliasCmdMessage.getCode();

        int text = R.string.bind_alias_unknown_exception;
        switch (Integer.valueOf(code)) {
            case PushConsts.BIND_ALIAS_SUCCESS:
                text = R.string.bind_alias_success;
                break;
            case PushConsts.ALIAS_ERROR_FREQUENCY:
                text = R.string.bind_alias_error_frequency;
                break;
            case PushConsts.ALIAS_OPERATE_PARAM_ERROR:
                text = R.string.bind_alias_error_param_error;
                break;
            case PushConsts.ALIAS_REQUEST_FILTER:
                text = R.string.bind_alias_error_request_filter;
                break;
            case PushConsts.ALIAS_OPERATE_ALIAS_FAILED:
                text = R.string.bind_alias_unknown_exception;
                break;
            case PushConsts.ALIAS_CID_LOST:
                text = R.string.bind_alias_error_cid_lost;
                break;
            case PushConsts.ALIAS_CONNECT_LOST:
                text = R.string.bind_alias_error_connect_lost;
                break;
            case PushConsts.ALIAS_INVALID:
                text = R.string.bind_alias_error_alias_invalid;
                break;
            case PushConsts.ALIAS_SN_INVALID:
                text = R.string.bind_alias_error_sn_invalid;
                break;
            default:
                break;

        }

        Log.d(TAG, "bindAlias result sn = " + sn + ", code = " + code + ", text = " + getResources().getString(text));

    }

    private void unbindAliasResult(UnBindAliasCmdMessage unBindAliasCmdMessage) {
        String sn = unBindAliasCmdMessage.getSn();
        String code = unBindAliasCmdMessage.getCode();

        int text = R.string.unbind_alias_unknown_exception;
        switch (Integer.valueOf(code)) {
            case PushConsts.UNBIND_ALIAS_SUCCESS:
                text = R.string.unbind_alias_success;
                break;
            case PushConsts.ALIAS_ERROR_FREQUENCY:
                text = R.string.unbind_alias_error_frequency;
                break;
            case PushConsts.ALIAS_OPERATE_PARAM_ERROR:
                text = R.string.unbind_alias_error_param_error;
                break;
            case PushConsts.ALIAS_REQUEST_FILTER:
                text = R.string.unbind_alias_error_request_filter;
                break;
            case PushConsts.ALIAS_OPERATE_ALIAS_FAILED:
                text = R.string.unbind_alias_unknown_exception;
                break;
            case PushConsts.ALIAS_CID_LOST:
                text = R.string.unbind_alias_error_cid_lost;
                break;
            case PushConsts.ALIAS_CONNECT_LOST:
                text = R.string.unbind_alias_error_connect_lost;
                break;
            case PushConsts.ALIAS_INVALID:
                text = R.string.unbind_alias_error_alias_invalid;
                break;
            case PushConsts.ALIAS_SN_INVALID:
                text = R.string.unbind_alias_error_sn_invalid;
                break;
            default:
                break;

        }

        Log.d(TAG, "unbindAlias result sn = " + sn + ", code = " + code + ", text = " + getResources().getString(text));

    }


    private void feedbackResult(FeedbackCmdMessage feedbackCmdMsg) {
        String appid = feedbackCmdMsg.getAppid();
        String taskid = feedbackCmdMsg.getTaskId();
        String actionid = feedbackCmdMsg.getActionId();
        String result = feedbackCmdMsg.getResult();
        long timestamp = feedbackCmdMsg.getTimeStamp();
        String cid = feedbackCmdMsg.getClientId();

        Log.d(TAG, "onReceiveCommandResult -> " + "appid = " + appid + "\ntaskid = " + taskid + "\nactionid = " + actionid + "\nresult = " + result
                + "\ncid = " + cid + "\ntimestamp = " + timestamp);
    }

    //反射设置该应用为flyme系统内部应用,用于支持自定义状态栏小图标、通知栏大图标, code from sodino
//    public static void flymeNotification(Notification notification, Bitmap largeIcon) {
//        Notification mFlymeNotification = null;
//        boolean internalApp = true;
//        //设置该应用为系统内部应用,用于支持自定义状态栏小图标, code from sodino
//        try {
//            if (mFlymeNotification == null) {
//                mFlymeNotification = Notification.class.getDeclaredField("mFlymeNotification");
//            }
//            if (mInternalApp == null) {
//                Class<?> NotificationExt = Class.forName("android.app.NotificationExt");
//                mInternalApp = NotificationExt.getDeclaredField("internalApp");
//                mInternalApp.setAccessible(true);
//
//                mNotificationBitmapIcon = NotificationExt.getDeclaredField("notificationBitmapIcon");
//                mNotificationBitmapIcon.setAccessible(true);
//            }
//
//            Object flymeNotification = mFlymeNotification.get(notification);
//            // 标识为内部应用，允许自定义smallIcon, code from sodino
//            mInternalApp.set(flymeNotification, internalApp ? 1 : 0);
//
//            // 反射：设置大图标，等同于Notification.Builder.setLargeIcon(bitmap)
//            mNotificationBitmapIcon.set(flymeNotification, largeIcon);
//        } catch (Exception e) {
//            PushkitUtil.log().e("flymeNotification", e);
//        }
//    }

}