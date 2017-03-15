package com.learzhu.browser.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5Util.java是极搜浏览器的MD5加密的工具类。
 *
 * @author Learzhu
 * @version 2.2.5 2017/2/28 18:53
 * @update UserName 2017/2/28 18:53
 * @updateDes
 */

public class MD5Util {
    private static final String TAG = MD5Util.class.getSimpleName();
    private static final int STREAM_BUFFER_LENGTH = 1024;

    public static MessageDigest getDigest(final String algorithm) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithm);
    }

    /**
     * 获取MD5加密后的String
     *
     * @param string
     * @return
     */
    public static String parseToMd5String(String string) throws UnsupportedEncodingException {
        byte[] bytes = md5(string.getBytes());
        return new String(bytes, "UTF-8");
    }

    public static byte[] md5(String txt) {
        return md5(txt.getBytes());
    }

    public static byte[] md5(byte[] bytes) {
        try {
            MessageDigest digest = getDigest("MD5");
            digest.update(bytes);
            return digest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] md5(InputStream is) throws NoSuchAlgorithmException, IOException {
        return updateDigest(getDigest("MD5"), is).digest();
    }

    public static MessageDigest updateDigest(final MessageDigest digest, final InputStream data) throws IOException {
        final byte[] buffer = new byte[STREAM_BUFFER_LENGTH];
        int read = data.read(buffer, 0, STREAM_BUFFER_LENGTH);

        while (read > -1) {
            digest.update(buffer, 0, read);
            read = data.read(buffer, 0, STREAM_BUFFER_LENGTH);
        }
        return digest;
    }
}
