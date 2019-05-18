package com.learzhu.browser.glide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * ExpandRecyclerView.java  是液总汇的可嵌套在ScrollView中类。
 * 解决ScrollView嵌套ListView和GridView造成控件间的滑动冲突问题（
 *
 * @author kk
 * @version 2.0.0 2018/1/20 14:40
 * @update kk 2018/1/20 14:40
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class ExpandRecyclerView extends RecyclerView {
    public ExpandRecyclerView(Context context) {
        super(context);
    }

    public ExpandRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpandRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        //高度可扩展 父控件允许的最大尺寸
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
