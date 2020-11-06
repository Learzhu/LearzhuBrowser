/**
 *
 */
package com.learzhu.browser.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @author Ryan Hu
 *
 */
public class ToastUtil {

    public static void showShortToast(Context context, String message) {
        if (context != null) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showLongToast(Context context, String message) {
        if (context != null) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }
}
