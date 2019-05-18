package com.learzhu.browser.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.learzhu.browser.R;
import com.zhy.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

public class VlayoutRecyclerViewActivity extends AppCompatActivity {

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
        Intent intent = new Intent(context, VlayoutRecyclerViewActivity.class);
        context.startActivity(intent);
    }

    private void initRecyclerView() {
        mItemBeans = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mItemBeans.add(new ItemBean(i + "", true));
        }
//        mAdapter = new CommonAdapter<ItemBean>(this, R.layout.item_recyclerview, mItemBeans) {
//            @Override
//            protected void convert(ViewHolder holder, ItemBean itemBean, int position) {
//                holder.setText(R.id.tv_name, itemBean.getName());
//                holder.setOnClickListener(R.id.btn, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //                        mItemBeans.get(15).setName("修改成功");
//                        for (int i = 0; i < mItemBeans.size(); i++) {
//                            if (i % 5 == 0) {
//                                mItemBeans.get(i).setName("修改成功");
//                            }
//                        }
//                        mAdapter.notifyDataSetChanged();
//                    }
//                });
//            }
//        };
        final VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        //// 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);

        //这个相当于适配器的类，但是他可以管理更多适配器去进行布局，所以相当于适配器的管理类，用于之后添加所有的适配器的集合
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        //这个集合是用来存放你写的适配器的。
        List<DelegateAdapter.Adapter> adapters = new ArrayList<>();
        adapters.add(new BaseItemsAdapter(VlayoutRecyclerViewActivity.this, new LinearLayoutHelper(20), "#bbbbbb", 20));
        /*添加了所有的适配器之后添加到*/
        delegateAdapter.addAdapters(adapters);
        /*设置recycleView*/
        mRecyclerView.setAdapter(delegateAdapter);
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
