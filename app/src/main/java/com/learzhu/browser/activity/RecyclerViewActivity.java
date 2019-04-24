package com.learzhu.browser.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.learzhu.browser.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class RecyclerViewActivity extends AppCompatActivity {

    private CommonAdapter<ItemBean> mAdapter;

    private List<ItemBean> mItemBeans;

    private RecyclerView mRecyclerView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        initRecyclerView();
    }

    /**
     * 售后订单列表的界面
     *
     * @param context 上下文
     */
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, RecyclerViewActivity.class);
        context.startActivity(intent);
    }

    private void initRecyclerView() {
        mItemBeans = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mItemBeans.add(new ItemBean(i + "", true));
        }
        mAdapter = new CommonAdapter<ItemBean>(this, R.layout.item_recyclerview, mItemBeans) {
            @Override
            protected void convert(ViewHolder holder, ItemBean itemBean, int position) {
                holder.setText(R.id.tv_name, itemBean.getName());
                holder.setOnClickListener(R.id.btn, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //                        mItemBeans.get(15).setName("修改成功");
                        for (int i = 0; i < mItemBeans.size(); i++) {
                            if (i % 5 == 0) {
                                mItemBeans.get(i).setName("修改成功");
                            }
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                });
            }
        };
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    class ItemBean {
        String name;
        boolean isOk;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isOk() {
            return isOk;
        }

        public void setOk(boolean ok) {
            isOk = ok;
        }

        public ItemBean(String name) {
            this.name = name;
        }

        public ItemBean(String name, boolean isOk) {
            this.name = name;
            this.isOk = isOk;
        }
    }
}
