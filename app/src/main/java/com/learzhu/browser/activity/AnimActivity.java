package com.learzhu.browser.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.learzhu.browser.R;

import java.util.ArrayList;
import java.util.List;

import static android.animation.ValueAnimator.INFINITE;
import static android.view.View.VISIBLE;

public class AnimActivity extends AppCompatActivity {
    private static final String TAG = "AnimActivity";
    /**
     * 当前的整个控件
     */
    private View mRootView;

    /**
     * 显示下拉刷新完成显示的文字
     */
    private TextView mRefreshDoneTv;

    /**
     * 显示下拉刷新下拉的文字
     */
    private TextView mPullDownTv;

    /**
     * 左右的两个动画图标
     */
    private ImageView mLeftIv;
    private ImageView mRightIv;

    /**
     * 显示刷完成后的图标
     */
    private ImageView mDoneIv;

    /**
     * 刷新完成后显示的控件
     */
    private LinearLayout mDoneLl;

    /**
     * 水平的显示圆点的布局
     */
    private RelativeLayout mBobbleRl;

    /**
     * 动画
     */
    private Button mAnimBtn;

    /**
     * 测试的控件
     */
    private TextView mTestTv;

    private int mRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        mPullDownTv = (TextView) findViewById(R.id.tv_refresh_pull);
        mBobbleRl = (RelativeLayout) findViewById(R.id.rl_refresh);
        mLeftIv = (ImageView) findViewById(R.id.iv_refresh_left);
        mRightIv = (ImageView) findViewById(R.id.iv_refresh_right);
        mDoneLl = (LinearLayout) findViewById(R.id.ll_refresh_done);
        mAnimBtn = (Button) findViewById(R.id.btn_start);
        mTestTv = (TextView) findViewById(R.id.tv_test);
        mAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateRefresh();
                doAnimatorListener();
            }
        });
        mRight = mBobbleRl.getRight();
        Log.d(TAG, "onCreate: mRight" + mRight);
    }


    /**
     * 下拉刷新的动画
     */
    public void animateRefresh() {
        AnimatorSet set = new AnimatorSet();
        List<Animator> animatorList = new ArrayList<>();

        //水平的动画
        ObjectAnimator moveAnimatorLeft = ObjectAnimator.ofFloat(mLeftIv, "translationX", 0, 290);
        moveAnimatorLeft.setDuration(2000);
        moveAnimatorLeft.setRepeatMode(ValueAnimator.REVERSE);
        moveAnimatorLeft.setRepeatCount(INFINITE);

        ObjectAnimator moveAnimatorRight = ObjectAnimator.ofFloat(mRightIv, "translationX", 0, -290);
        moveAnimatorRight.setDuration(2000);
        moveAnimatorRight.setRepeatCount(INFINITE);
        moveAnimatorRight.setRepeatMode(ValueAnimator.REVERSE);

        //顶部的文字下拉
        ValueAnimator refreshTvPullAnimator = ValueAnimator.ofInt(0, 100);
        refreshTvPullAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
//                mPullDownTv.layout(mPullDownTv.getLeft(), mPullDownTv.getTop() + value, mPullDownTv.getRight(), mPullDownTv.getBottom() + value);
                mPullDownTv.layout(mPullDownTv.getLeft(), value, mPullDownTv.getLeft() + mPullDownTv.getWidth(), mPullDownTv.getHeight() + value);
                if (value == 100) {
                    //到最后隐藏
                    mPullDownTv.setVisibility(View.GONE);
                    //显示左右的两个图标
                    mLeftIv.setVisibility(VISIBLE);
                    mRightIv.setVisibility(VISIBLE);
                }
            }
        });
        refreshTvPullAnimator.setDuration(500);
        refreshTvPullAnimator.setRepeatCount(0);

        //水平的两个球的水平滑动   外层相对布局内层的控件的getleft会出错
//        ValueAnimator moveAnimator = ValueAnimator.ofInt(0, 100, 0);
//        ValueAnimator moveAnimator = ValueAnimator.ofInt(0, 200, 0);
//        moveAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int value = (int) animation.getAnimatedValue();
//                //左边的向右运动，右边的向左运动
////                mLeftIv.layout(mLeftIv.getLeft() + value, mLeftIv.getTop(), mLeftIv.getRight() + value, mLeftIv.getBottom());
////                mRightIv.layout(mRightIv.getLeft() - value, mRightIv.getTop(), mRightIv.getRight() - value, mRightIv.getBottom());
//
////                mLeftIv.layout(value, 50, mLeftIv.getWidth() + value, mLeftIv.getHeight() + 50);
////                mRightIv.layout(720 - mRightIv.getWidth() - value, 50, 720 - value, mRightIv.getHeight() + 50);
//
////                mLeftIv.layout(200 + value, 50, 200 + mLeftIv.getWidth() + value, mLeftIv.getHeight() + 50);
////                mRightIv.layout(400 - value, 50, 400 + mRightIv.getWidth() - value, mRightIv.getHeight() + 50);
//
//                mLeftIv.layout(value, mLeftIv.getTop(), mLeftIv.getWidth() + value, mLeftIv.getTop() + mLeftIv.getHeight());
//                LogTest.d(TAG, "mLeftIv l:" + value + "  t:" + value + " r:" + (mLeftIv.getWidth() + value) + " b:" + (mLeftIv.getTop() + mLeftIv.getHeight()));
//
////                mRightIv.layout(mRightIv.getRight() - value - mRightIv.getWidth(), mRightIv.getTop(), mRightIv.getRight() - value, mRightIv.getHeight() + mRightIv.getTop());
//                mRight = mBobbleRl.getRight();
//                LogTest.d(TAG, "onAnimationUpdate: mRight" + mRight);
//
//                mRightIv.layout(mRight - value - mRightIv.getWidth(), mRightIv.getTop(), mRight - value, mRightIv.getHeight() + mRightIv.getTop());
////                LogTest.d(TAG, "mRightIv l:" + (mRightIv.getRight() - value - mRightIv.getWidth() + "") + "  t:" + mRightIv.getTop() + " r:" + (mRightIv.getRight() - value) + " b:" + (mRightIv.getHeight() + mRightIv.getTop()));
//                LogTest.d(TAG, "mRightIv l:" + (mRight - value - mRightIv.getWidth() + "") + "  t:" + mRightIv.getTop() + " r:" + ( mRight  - value) + " b:" + (mRightIv.getHeight() + mRightIv.getTop()));
//            }
//        });
//        moveAnimator.setRepeatCount(10);
//        moveAnimator.setDuration(1000);
////        moveAnimator.setRepeatMode(ValueAnimator.REVERSE);
////        moveAnimator.setRepeatCount(ValueAnimator.INFINITE);
////        moveAnimator.setRepeatCount(INFINITE);
////        moveAnimator.setDuration(10000);
//        animatorList.add(moveAnimator);

        animatorList.add(refreshTvPullAnimator);
        animatorList.add(moveAnimatorLeft);
        animatorList.add(moveAnimatorRight);

        set.playTogether(animatorList);
        set.start();
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                //最终动画结束后显示刷新完成的文字
                mDoneLl.setVisibility(VISIBLE);
            }
        });

        mDoneLl.postDelayed(new Runnable() {
            @Override
            public void run() {
                mBobbleRl.setVisibility(View.GONE);
                mDoneLl.setVisibility(VISIBLE);
                //调用刷新结束的时候延迟显示动画
                mDoneLl.animate().alpha(1f).alpha(0).setDuration(200).start();
            }
        }, 5000);


    }


    private ValueAnimator doAnimatorListener() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 400);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                mTestTv.layout(mTestTv.getLeft(), curValue, mTestTv.getRight(), curValue + mTestTv.getHeight());
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d("qijian", "animation start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("qijian", "animation end");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d("qijian", "animation cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d("qijian", "animation repeat");
            }
        });
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(INFINITE);
        animator.setDuration(1000);
        animator.start();
        return animator;
    }
}
