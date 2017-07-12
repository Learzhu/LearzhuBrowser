package com.learzhu.browser.utils;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/7/12 19:44
 * @update Learzhu 2017/7/12 19:44
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class HttpRequestUtil {

    private static final String TAG = "HttpRequestUtil";

    public static String sendAndGetStringByHttpClient(String url) {
        String serverDataString = null;
        HttpGet get = new HttpGet(url);
        try {
            HttpClient client = new DefaultHttpClient();
            HttpResponse response = client.execute(get);
            int code = response.getStatusLine().getStatusCode();
            Log.i("bzjm", "StatusCode:" + code);

            if (code == 200) {
                serverDataString = EntityUtils.toString(response.getEntity(), "gb2312");

                Log.i("bzjm", "接收字符串数据成功\nServerData:" + serverDataString);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return serverDataString;
    }

    /**
     * 请求并返回一个String
     *
     * @param path
     * @return
     */
    public static String sendAndGetStringByHttpUrlConnection(String path) {
        URL url = null;
        try {
            url = new URL(path.trim());
            //打开连接
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            HttpURLConnection get = new HttpURLConnection(url) {
                @Override
                public void disconnect() {

                }

                @Override
                public boolean usingProxy() {
                    return false;
                }

                @Override
                public void connect() throws IOException {

                }
            };

            if (200 == urlConnection.getResponseCode()) {
                //得到输入流
                InputStream is = urlConnection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while (-1 != (len = is.read(buffer))) {
                    baos.write(buffer, 0, len);
                    baos.flush();
                }
                Log.i(TAG, "sendAndGetStringByHttpUrlConnection 接收字符串数据成功\nServerData:" + baos.toString("utf-8"));
                return baos.toString("utf-8");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    //获取其他页面的数据

    /**
     * POST请求获取数据
     */
    public static String postDownloadJson(String path, String post) {
        URL url = null;
        try {
            url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
            printWriter.write(post);//post的参数 xx=xx&yy=yy
            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while ((len = bis.read(arr)) != -1) {
                bos.write(arr, 0, len);
                bos.flush();
            }
            bos.close();
            return bos.toString("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
