package com.learzhu.browser.utils;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;

/**
 * ScreenStatusUtil.java是极搜浏览器的用于判断屏幕状态的工具类。
 *
 * @author Learzhu
 * @version 2.2.5 2017/2/24 17:47
 * @update UserName 2017/2/24 17:47
 * @updateDes
 */

public class ScreenStatusUtil {

    /**
     * 如果为true，则表示屏幕“亮”了，否则屏幕“暗”了。
     * 屏幕“亮”，表示有两种状态：a、未锁屏 b、目前正处于解锁状态 。这两种状态屏幕都是亮的
     * 屏幕“暗”，表示目前屏幕是黑的 。
     *
     * @param context 用于获取系统服务的上下文
     * @return
     */
    public static boolean isScreenLight(Context context) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = pm.isScreenOn();
        return isScreenOn;
    }

    /**
     * 如果flag为true，表示有两种状态：a、屏幕是黑的 b、目前正处于解锁状态 。
     * 如果flag为false，表示目前未锁屏
     * mark 注释是否有问题？
     *
     * @param context
     * @return
     */
    public static boolean isScreenLocked(Context context) {
        KeyguardManager mKeyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        boolean flag = mKeyguardManager.inKeyguardRestrictedInputMode();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            flag = mKeyguardManager.isKeyguardLocked();
        }
        return flag;
    }
}
