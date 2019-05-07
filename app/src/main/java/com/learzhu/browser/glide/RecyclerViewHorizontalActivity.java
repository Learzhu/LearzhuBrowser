package com.learzhu.browser.glide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.learzhu.browser.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHorizontalActivity extends AppCompatActivity {
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    //    private String imgUrl = "http://yzh-img-test.oss-cn-hangzhou.aliyuncs.com//shop/ad/20190419114744813/0d4c8f5a43c711e9943200163e101d35.jpg";
    private String imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556107572209&di=0b7486647c746b9435058abca30ea212&imgtype=0&src=http%3A%2F%2Fmeiti.fabumao.cn%2F1132569%2F20181121180912998.jpg";

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, RecyclerViewHorizontalActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_horizontal);
        ButterKnife.bind(this);
        loadExpandRvRTL();
    }

    /**
     * 从右侧开始布局的列表
     */
    private void loadExpandRvRTL() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(imgUrl);
        }
        GlideErvAdapter glideErvAdapter = new GlideErvAdapter(R.layout.item_glide, list, this);
        //    GridLayoutManager.VERTICAL  方向垂直 水平5列 垂直滚动
        //    GridLayoutManager.HORIZONTAL  方向水平 垂直5列 水平滚动
        //reverseLayout反转布局 从左到右就变成从右到左
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 5, GridLayoutManager.HORIZONTAL, false) {

            @Override
            protected boolean isLayoutRTL() {
                return true;
            }
        });
        mRecyclerView.setAdapter(glideErvAdapter);
    }

}
