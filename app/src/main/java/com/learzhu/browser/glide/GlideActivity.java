package com.learzhu.browser.glide;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.learzhu.browser.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;

public class GlideActivity extends AppCompatActivity {
    @BindView(R.id.iv1)
    ImageView mImageView1;
    @BindView(R.id.iv2)
    ImageView mImageView2;
    @BindView(R.id.iv3)
    ImageView mImageView3;
    @BindView(R.id.iv4)
    ImageView mImageView4;

    private String imgUrl = "http://yzh-img-test.oss-cn-hangzhou.aliyuncs.com//shop/ad/20190419114744813/0d4c8f5a43c711e9943200163e101d35.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        loadImg();
    }

    private void loadImg() {
        GlideUtil.loadRoundedCornersImg(this, imgUrl, mImageView1);
        GlideUtil.loadSourceImg(this, imgUrl, mImageView2);
    }

}
