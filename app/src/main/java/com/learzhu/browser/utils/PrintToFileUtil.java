package com.learzhu.browser.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * PrintToFileUtil.java 是视在APP的写入到文件的工具类。
 *
 * @author Learzhu
 * @version 1.8.2.0 2021/5/27 11:09
 * @update learzhu 2021/5/27 11:09
 * @updateDes
 * @include {@link }
 * @used {@link }
 * @goto {@link }
 */
public class PrintToFileUtil {
    private static ExecutorService sExecutor;

    public static void input2File(String input) {
        input = DateUtil.getCurrentDateStr() + " " + input;
        FileOutputStream fos = null;
        try {
//            File dirFile = new File(FileUtils.logPath);
            File dirFile = new File("");
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
//            File file = new File(FileUtils.logPath, "log.txt");
            File file = new File("", "log.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file, true);
            fos.write(input.getBytes(), 0, input.getBytes().length);
            fos.write("\r\n".getBytes());//写入换行
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将内容直接写过文件中，自己设置路径
     * 这个是一边打印日志，一边将日志写入到file
     * 不建议直接new一个子线程做写入逻辑，建议开启线程池，避免到处开启线程损耗性能
     *
     * @param input    写入内容
     * @param filePath 路径
     * @return
     */
    public static boolean input2File(final String input, final String filePath) {
        if (sExecutor == null) {
            sExecutor = Executors.newScheduledThreadPool(5);
        }
        Future<Boolean> submit = sExecutor.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                BufferedWriter bw = null;
                try {
                    // 构造给定文件名的FileWriter对象，并使用布尔值指示是否追加写入的数据。
                    FileWriter fileWriter = new FileWriter(filePath, true);
                    bw = new BufferedWriter(fileWriter);
                    bw.write(DateUtil.getCurrentDateStr() + input);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                } finally {
                    try {
                        if (bw != null) {
                            bw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        try {
            return submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

//    static String printDeviceInfo() {
//        String versionName = "";
//        int versionCode = 0;
//        try {
//            PackageInfo pi = App.instance.getPackageManager().getPackageInfo(App.instance.getPackageName(), 0);
//            if (pi != null) {
//                versionName = pi.versionName;
//                versionCode = pi.versionCode;
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        final String head = "************* Log Head ****************" +
//                "\nDevice Manufacturer: " + Build.MANUFACTURER +// 设备厂商
//                "\nDevice Model       : " + Build.MODEL +// 设备型号
//                "\nAndroid Version    : " + Build.VERSION.RELEASE +// 系统版本
//                "\nAndroid SDK        : " + Build.VERSION.SDK_INT +// SDK 版本
//                "\nApp VersionName    : " + versionName +
//                "\nApp VersionCode    : " + versionCode +
//                "\n************* Log Head ****************\n\n";
//        return head;
//    }

}
