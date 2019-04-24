package com.learzhu.browser.activity;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.learzhu.browser.R;


/**
 * BaseItemsAdapter.java是阿里巴巴适配器的类。
 * 链接：https://www.jianshu.com/p/52c3c50103a8
 *
 * @author Learzhu
 * @version 2.0.0 2018-12-27 14:37
 * @update Learzhu 2018-12-27 14:37
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class BaseItemsAdapter extends DelegateAdapter.Adapter<BaseItemsAdapter.ItemHolder> {
    private Context mContext;
    private LayoutHelper mHelper;
    private String mColor;/*这个颜色值主要是为了区分样式的*/
    private int mCount;

    public BaseItemsAdapter(Context context, LayoutHelper helper, String color, int count) {
        mContext = context;
        mHelper = helper;
        this.mColor = color;
        this.mCount = count;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_linear, parent, false);
        return new ItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.itemView.setBackgroundColor(Color.parseColor(mColor));
        holder.mTitleTv.setText("这是基类的布局" + position);
    }

    @Override
    public int getItemCount() {
        return mCount;
    }

    static class ItemHolder extends BaseItemHolder {
        public final View mView;
        public final TextView mTitleTv;

        public ItemHolder(View view) {
            super(view);
            mView = view;
            mTitleTv = (TextView) view.findViewById(R.id.title);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleTv.getText() + "'";
        }
    }

    static class BaseItemHolder extends RecyclerView.ViewHolder {

        public static volatile int existing = 0;
        public static int createdTimes = 0;

        public BaseItemHolder(View itemView) {
            super(itemView);
            createdTimes++;
            existing++;
        }

        @Override
        protected void finalize() throws Throwable {
            existing--;
            super.finalize();
        }
    }
}
