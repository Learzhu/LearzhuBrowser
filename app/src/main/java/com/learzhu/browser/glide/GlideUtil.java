package com.learzhu.browser.glide;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.RemoteViews;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.NotificationTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.learzhu.browser.R;

import java.io.File;

import androidx.annotation.Nullable;

/**
 * GlideUtil.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2019-04-23 13:51
 * @update Learzhu 2019-04-23 13:51
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class GlideUtil {
    /**
     * 加载圆角图片
     *
     * @param context 如果是activity glide会与其生命周期关联,在onStop()中取消加载图片,如果
     *                想要始终加载图片则需要传入Application实例
     * @param url
     * @param target
     */
    public static void loadRoundedCornersImg(Context context, String url, ImageView target) {
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.img_loading)
                .error(R.drawable.img_loading)
                .transform(new RoundedCorners(40))
                .transition(new DrawableTransitionOptions().crossFade(200))//渐显效果
                .into(target);
    }

    /**
     * 加载原图片
     *
     * @param c
     * @param url
     * @param target
     */
    public static void loadSourceImg(Context c, String url, ImageView target) {
        Glide.with(c)
                .load(url)
                .transition(new DrawableTransitionOptions().crossFade(200))
                .centerCrop()
                //.sizeMultiplier(0.5f)//如果原图过大那么使用这个
                .into(target);
    }

    /**
     * 加载图片不需要缓存的
     *
     * @param c
     * @param url
     * @param target
     */
    public static void loadSourseImgWithNoCache(Context c, String url, ImageView target) {
        Glide.with(c)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .centerCrop()
                .transition(new DrawableTransitionOptions().crossFade(200))
                .into(target);
    }

    /**
     * 根据资源ID加载图片
     *
     * @param c
     * @param resourceId
     * @param target
     * @param defaultId
     */
    public static void loadResourseImg(Context c, int resourceId, ImageView target, int defaultId) {
        Glide.with(c)
                .load(resourceId)
                .placeholder(defaultId)
                .transition(new DrawableTransitionOptions().crossFade(200))
                .centerCrop()
                .into(target);
    }

    /**
     * 根据图片路径加载图片
     *
     * @param c
     * @param imgFile
     * @param target
     * @param defaultId
     */
    public static void loadFileImg(Context c, File imgFile, ImageView target, int defaultId) {
        Glide.with(c)
                .load(imgFile)
                .placeholder(defaultId)
                .transition(new DrawableTransitionOptions().crossFade(200))
                .centerCrop()
                .into(target);
    }

    /**
     * 加载Gif为一张静态图片
     *
     * @param context
     * @param url
     */
    public static void LoadGiftAsBitmap(Context context, String url, ImageView imageView) {
        Glide.with(context).asBitmap().load(url).into(imageView);
    }

    /**
     * 你想只有加载对象是Gif时才能加载成功
     *
     * @param context
     * @param url
     */
    public static void LoadGiftAsGist(Context context, String url, ImageView imageView, int erroId) {
        Glide.with(context).asGif().load(url).error(erroId).into(imageView);

        //只加载一次gift图时调用
        //        GlideApp.with(context).load(url)
        //                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
        //                .into(new GlideDrawableImageViewTarget(imageView,1));
    }

    /**
     * 加载缩略图,会自动与传入的fragment绑定生命周期,加载请求现在会自动在onStop中暂停在，onStart中重新开始。
     * 需要保证 ScaleType 的设置是正确的。
     *
     * @param fragment
     * @param url
     * @param imageView
     */
//    public static void LoadThumbNail(Fragment fragment, String url, ImageView imageView) {
//        GlideApp.with(fragment).load(url).thumbnail(0.1f).into(imageView);
//    }

    /**
     * 上传一张大小为xPx*yPx像素的用户头像的图片bytes数据
     *
     * @param context
     * @param url
     * @param xPx
     * @param yPx
     */
    public static void decodeResorse(Context context, File url, int xPx, int yPx) {
        Glide
                .with(context)
                .load(url)
                .into(new SimpleTarget<Drawable>(xPx, yPx) {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        //上传动作
                    }
                })
        ;
    }

    /**
     * 显示本地视频(网络视频无效)
     *
     * @param context
     * @param filePath
     * @param imageView
     */
    public static void LoadShowLocalVidio(Context context, String filePath, ImageView imageView) {
        Glide.with(context).load(Uri.fromFile(new File(filePath))).into(imageView);
    }

    /**
     * 在通知栏中显示从网络上请求的图片
     *
     * @param context
     * @param remoteViews
     * @param viewId
     * @param notification
     * @param notificationId
     * @param url
     */
    public static void ShowImgInNotification(Context context, RemoteViews remoteViews, int viewId, Notification
            notification, int notificationId, String url) {
        NotificationTarget target = new NotificationTarget(context, viewId, remoteViews, notification, notificationId);
        Glide.with(context.getApplicationContext()).asBitmap().load(url).into(target);
    }

    /**
     * 下载图片,耗时操作不能放在主线程中进行
     *
     * @param context
     * @param url
     */
    public static void downLoadImage(Context context, String url) {

        try {
            Glide.with(context).asBitmap().load(url).centerCrop().listener(new RequestListener<Bitmap>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean
                        isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource
                        dataSource, boolean isFirstResource) {
                    return false;
                }
            }).submit().get();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 清除缓存
     *
     * @param context
     */
    public void clearCache(final Context context) {
        clearMemoryCache(context);
        new Thread(new Runnable() {
            @Override
            public void run() {
                clearDiskCache(context);
            }
        }).start();
    }

    /**
     * 清除内存缓存
     *
     * @param context
     */
    public void clearMemoryCache(Context context) {
//        GlideApp.get(context).clearMemory();
    }

    /**
     * 清除磁盘缓存
     *
     * @param context
     */
    public void clearDiskCache(Context context) {
//        GlideApp.get(context).clearDiskCache();
    }
}
