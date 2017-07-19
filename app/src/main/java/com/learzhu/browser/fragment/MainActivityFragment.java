package com.learzhu.browser.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.learzhu.browser.R;
import com.learzhu.browser.activity.AnimActivity;
import com.learzhu.browser.utils.ToastUtil;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    /**
     * 首页的一个ListView
     */
    private ListView mListView;
    ArrayAdapter adapter = null;
    ArrayList<String> list1 = new ArrayList<String>();

    private TextView mTextView1, mTextView2;

    private View mView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mListView = (ListView) view.findViewById(R.id.list_view);
        View headerView = inflater.inflate(R.layout.layout_listview_header, container, true);
//        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_listview_header, container, false);
//        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_listview_header, null);
        mTextView1 = (TextView) headerView.findViewById(R.id.headera_tv);
        mTextView2 = (TextView) headerView.findViewById(R.id.headerb_tv);
        mView = headerView.findViewById(R.id.headerc);
        mTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShortToast(getContext(), "跳转到动画页");
//                mView.setBackgroundResource(android.R.color.transparent);
//                startActivity(new Intent((getActivity()), Main3Activity.class));
                startActivity(new Intent((getActivity()), AnimActivity.class));
            }
        });
        //修改第三部分的颜色
        mTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShortToast(getContext(), "BB");
                mView.setBackgroundResource(R.color.colorAccent);
            }
        });
        mListView.addHeaderView(headerView);
        initAdapter();
        return view;
    }

    private void initAdapter() {
        list1.add("pfg");
        list1.add("124");
        list1.add("234");
        list1.add("456");
        list1.add("567");
        //这里使用的是自定义的layout和TextView控件,注意使用自定的layout时需要用对ArrayAdapter的构造函数
        // （ArrayAdapter(Context context, int resource, int textViewResourceId, List<T> objects) ）,
        // 其实也不难理解因为要指定int textViewResourceId就需要知道是在哪个layout中用int resource来表示。
//        adapter = new ArrayAdapter(this, R.layout.view, R.id.textview1, list1);

        // 这里使用的android自带的android.R.layout.simple_list_item_1
        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list1);

        mListView.setAdapter(adapter);
//        changeAnimator();
    }
//    private class SimpleAdapter extends ArrayAdapter<String> {
//        public SimpleAdapter(Context context, int resource) {
//            super(context, resource);
//        }
//    }

    /**
     * 显示切换的动画
     */
    private void changeAnimator() {
        AnimatorSet showServerSet = new AnimatorSet();
        ObjectAnimator alphaAnimHiddeBackIv = ObjectAnimator.ofFloat(mTextView1, "alpha", 0, 1);
        ObjectAnimator alphaAnimHiddeNextIv = ObjectAnimator.ofFloat(mTextView2, "alpha", 1, 0);
        showServerSet.playTogether(alphaAnimHiddeBackIv, alphaAnimHiddeNextIv);
        showServerSet.setDuration(200);
        showServerSet.start();
    }

}
