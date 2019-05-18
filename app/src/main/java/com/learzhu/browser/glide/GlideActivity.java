package com.learzhu.browser.glide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.widget.ImageView;

import com.learzhu.browser.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlideActivity extends AppCompatActivity {
    @BindView(R.id.iv1)
    ImageView mImageView1;
    @BindView(R.id.iv2)
    ImageView mImageView2;
    @BindView(R.id.iv3)
    ImageView mImageView3;
    @BindView(R.id.iv4)
    ImageView mImageView4;
    @BindView(R.id.expandrv)
    ExpandRecyclerView mExpandRecyclerView;

    //    private String imgUrl = "http://yzh-img-test.oss-cn-hangzhou.aliyuncs.com//shop/ad/20190419114744813/0d4c8f5a43c711e9943200163e101d35.jpg";
    private String imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556107572209&di=0b7486647c746b9435058abca30ea212&imgtype=0&src=http%3A%2F%2Fmeiti.fabumao.cn%2F1132569%2F20181121180912998.jpg";

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, GlideActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);
        loadImg();
//        loadExpandRv();
        loadExpandRvRTL();
    }

    private void loadImg() {
        GlideUtil.loadRoundedCornersImg(this, imgUrl, mImageView1);
        GlideUtil.loadSourceImg(this, imgUrl, mImageView2);
    }

    private void loadExpandRv() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(imgUrl);
        }
        GlideErvAdapter glideErvAdapter = new GlideErvAdapter(R.layout.item_glide, list, this);
        mExpandRecyclerView.setLayoutManager(new GridLayoutManager(this, 2) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
//        mExpandRecyclerView.setLayoutManager(new LinearLayoutManager(this) {
//            @Override
//            public boolean canScrollVertically() {
//                return false;
//            }
//        });
        mExpandRecyclerView.setAdapter(glideErvAdapter);
    }

    /**
     * 从右侧开始布局的列表
     */
    private void loadExpandRvRTL() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(imgUrl);
        }
        GlideErvAdapter glideErvAdapter = new GlideErvAdapter(R.layout.item_glide, list, this);
        // HORIZONTAL或VERTICAL，实现横向GridView、纵向GridView效果
        //方向垂直 水平3列
        mExpandRecyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }

            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            protected boolean isLayoutRTL() {
                return true;
            }
        });
//        mExpandRecyclerView.setLayoutManager(new LinearLayoutManager(this) {
//            @Override
//            public boolean canScrollVertically() {
//                return false;
//            }
//        });
        mExpandRecyclerView.setAdapter(glideErvAdapter);
    }

}
