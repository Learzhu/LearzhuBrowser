package com.learzhu.browser;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import org.litepal.LitePal;

/**
 * LearzhuBrowserApp.java是极搜浏览器的类。
 *
 * @author 祝杭鹏
 * @version 2.2.5 2017/2/21
 * @update UserName 2017/2/21
 * @updateDes
 */
public class LearzhuBrowserApp extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        MultiDex.install(this);
        LitePal.initialize(this);
    }
    //    public static final String KEY_DEX2_SHA1 = "dex2-SHA1-Digest";
//    @Override
//    protected void attachBaseContext(Context base) {
//        super .attachBaseContext(base);
//        LogUtils.d( "loadDex", "App attachBaseContext ");
//        if (!quickStart() && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {//>=5.0的系统默认对dex进行oat优化
//            if (needWait(base)){
//                waitForDexopt(base);
//            }
//            MultiDex.install (this );
//        } else {
//            return;
//        }
//    }
//
//    @Override
//    public void onCreate() {
//        super .onCreate();
//        if (quickStart()) {
//            return;
//        }
//        ...
//    }
//
//    public boolean quickStart() {
//        if (StringUtils.contains( getCurProcessName(this), ":mini")) {
//            LogUtils.d( "loadDex", ":mini start!");
//            return true;
//        }
//        return false ;
//    }
//    //neead wait for dexopt ?
//    private boolean needWait(Context context){
//        String flag = get2thDexSHA1(context);
//        LogUtils.d( "loadDex", "dex2-sha1 "+flag);
//        SharedPreferences sp = context.getSharedPreferences(
//                PackageUtil.getPackageInfo(context). versionName, MODE_MULTI_PROCESS);
//        String saveValue = sp.getString(KEY_DEX2_SHA1, "");
//        return !StringUtils.equals(flag,saveValue);
//    }
//    /**
//     * Get classes.dex file signature
//     * @param context
//     * @return
//     */
//    private String get2thDexSHA1(Context context) {
//        ApplicationInfo ai = context.getApplicationInfo();
//        String source = ai.sourceDir;
//        try {
//            JarFile jar = new JarFile(source);
//            Manifest mf = jar.getManifest();
//            Map<String, Attributes> map = mf.getEntries();
//            Attributes a = map.get("classes2.dex");
//            return a.getValue("SHA1-Digest");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null ;
//    }
//    // optDex finish
//    public void installFinish(Context context){
//        SharedPreferences sp = context.getSharedPreferences(
//                PackageUtil.getPackageInfo(context).versionName, MODE_MULTI_PROCESS);
//        sp.edit().putString(KEY_DEX2_SHA1,get2thDexSHA1(context)).commit();
//    }
//
//
//    public static String getCurProcessName(Context context) {
//        try {
//            int pid = android.os.Process.myPid();
//            ActivityManager mActivityManager = (ActivityManager) context
//                    .getSystemService(Context. ACTIVITY_SERVICE);
//            for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
//                    .getRunningAppProcesses()) {
//                if (appProcess.pid == pid) {
//                    return appProcess. processName;
//                }
//            }
//        } catch (Exception e) {
//            // ignore
//        }
//        return null ;
//    }
//    public void waitForDexopt(Context base) {
//        Intent intent = new Intent();
//        ComponentName componentName = new
//                ComponentName( "com.zongwu", LoadResActivity.class.getName());
//        intent.setComponent(componentName);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        base.startActivity(intent);
//        long startWait = System.currentTimeMillis ();
//        long waitTime = 10 * 1000 ;
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB_MR1 ) {
//            waitTime = 20 * 1000 ;//实测发现某些场景下有些2.3版本有可能10s都不能完成optdex
//        }
//        while (needWait(base)) {
//            try {
//                long nowWait = System.currentTimeMillis() - startWait;
//                LogUtils.d("loadDex" , "wait ms :" + nowWait);
//                if (nowWait >= waitTime) {
//                    return;
//                }
//                Thread.sleep(200 );
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
