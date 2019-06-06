package com.learzhu.browser.verticaltablayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.learzhu.browser.R;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;

public class VerticalTabLayoutActivity extends AppCompatActivity {

    private VerticalTabLayout mTablayout;
    private VerticalPager mViewpager;
    private List<String> datas = new ArrayList<String>();
    private ViewPagerAdapter ViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_tab_layout);
        initView();
        initData();
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, VerticalTabLayoutActivity.class);
        context.startActivity(intent);
    }

    //    初始化控件
    private void initView() {
        mTablayout = (VerticalTabLayout) findViewById(R.id.tablayout);
        mViewpager = (VerticalPager) findViewById(R.id.viewpager);
    }

    //    初始化数据
    private void initData() {
        datas.add("推荐");
        datas.add("要闻");
        datas.add("娱乐");
        datas.add("科技");
        datas.add("汽车");
        datas.add("体育");
        datas.add("推荐");
        datas.add("要闻");
        datas.add("娱乐");
        datas.add("科技");
        datas.add("汽车");
        datas.add("体育");
        datas.add("推荐");
        datas.add("要闻");
        datas.add("娱乐");
        datas.add("科技");
        datas.add("汽车");
        datas.add("体育");

        //适配器
        ViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewpager.setAdapter(ViewPagerAdapter);
        //进行关联
        mTablayout.setupWithViewPager(mViewpager);
        /*mTablayout.setTabBadge(7, 32);
        mTablayout.setTabBadge(2, -1);
        mTablayout.setTabBadge(3, -1);
        mTablayout.setTabBadge(4, -1);*/

    }

    //    自定义适配器
    class ViewPagerAdapter extends FragmentPagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        //返回选项卡的文本 ，，，添加选项卡

        @Override
        public CharSequence getPageTitle(int position) {
            return datas.get(position);
        }
        //动态创建fragment对象并返回

        @Override
        public Fragment getItem(int position) {
//            创建布局
            VerticalCountFragment vcount = new VerticalCountFragment();
            Bundle bundle = new Bundle();
//            放入值
            bundle.putString("name", datas.get(position));
//            放入布局文件中
            vcount.setArguments(bundle);
            return vcount;
        }
        //返回数量

        @Override
        public int getCount() {
            return datas.size();
        }


    }
}
