package com.learzhu.browser.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.learzhu.browser.R;
import com.learzhu.browser.activity.AnimActivity;
import com.learzhu.browser.activity.RecyclerViewActivity;
import com.learzhu.browser.activity.TextSwitcherActivity;
import com.learzhu.browser.activity.VlayoutRecyclerViewActivity;
import com.learzhu.browser.event.CommonEvent;
import com.learzhu.browser.utils.ToastUtil;
import com.learzhu.browser.verticaltablayout.VerticalTabLayoutActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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

    private TextView mTextView1, mTextView2, mTextViewD, mTextViewE, mFTv;

    private View mView;

    private static final String TAG = "MainActivityFragment";

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mListView = (ListView) view.findViewById(R.id.list_view);
        View headerView = inflater.inflate(R.layout.layout_listview_header, container, true);
//        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_listview_header, container, false);
//        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_listview_header, null);
        mTextView1 = (TextView) headerView.findViewById(R.id.headera_tv);
        mTextView2 = (TextView) headerView.findViewById(R.id.headerb_tv);
        mTextViewD = (TextView) headerView.findViewById(R.id.headerd_tv);
        mTextViewE = (TextView) headerView.findViewById(R.id.headere_tv);
        mFTv = (TextView) headerView.findViewById(R.id.headerf_tv);
        String s1 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        String s2 = "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB";
//        mTextView2.setText(s1 + ":" + s2);
        mTextView2.setText("执行将Excel写入到SQLite");
        mView = headerView.findViewById(R.id.headerc);
        mTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                testSP();
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
                ToastUtil.showShortToast(getContext(), "执行将Excel写入到SQLite");
                ToastUtil.showShortToast(getActivity(), "执行将Excel写入到SQLite");
//                mView.setBackgroundResource(R.color.colorAccent);
                translateExcel2SQLite();
            }
        });
        mTextViewD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerViewActivity.actionStart(getActivity());
            }
        });
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VlayoutRecyclerViewActivity.actionStart(getActivity());
            }
        });
        mTextViewE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent((getActivity()), AnimActivity.class));
            }
        });
        mFTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomerDialog();
            }
        });
        headerView.findViewById(R.id.headerg_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerticalTabLayoutActivity.actionStart(getActivity());
            }
        });
        headerView.findViewById(R.id.textswitcher).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextSwitcherActivity.actionStart(getActivity());
            }
        });
        mListView.addHeaderView(headerView);
        initAdapter();
        return view;
    }

    private void showCustomerDialog() {
//        MaterialDialog materialDialog = new MaterialDialog(getActivity());
//        new MaterialDialog.Builder(this)// 初始化建造者
//                .title(R.string.title)// 标题
//                .content(R.string.content)// 内容
//                .positiveText(R.string.agree)
//                .negativeText(R.string.title)
//                .show();// 显示对话框

    }

    /**
     * 将Excel的内容保存到SQLite
     */
    private void translateExcel2SQLite() {
//        importSheet();
    }

    /**
     * 导入一个工作表
     * 通过sheet对象就可以对excel表格进行操作了
     * 1. 打开excel文件，我的excel文件放在了Assets包下，你也可以将文件放在SD卡下，只要路径正确就行
     * 2. 获取Workbook对象，通过查看Workbook源码可以看到，这是个抽象类，里面包含了很多对于Sheet表格访问的方法
     * 3. 获取第一页的Sheet表对象
     * 4. sheet.getRows()可以获取行数，sheet.getColumns()获取列数
     * 5. sheet.getCell(0, j).getContents()可以获得第j行第一列的内容，同理sheet.getCell(1, j).getContents()可以获取第j行第二列的内容
     */
//    private void importSheet() {
//        try {
//            // 1
////            InputStream is = getResources().getAssets().open("vipdb.xls");
////            InputStream is = getResources().getAssets().open("express100.xlsx");
//            InputStream is = getResources().getAssets().open("express100.xls");
//            // 2
//            Workbook book = Workbook.getWorkbook(is);
//            // 3 获取第一页的表对象
//            Sheet sheet = book.getSheet(0);
//            insertExpressBeans(sheet);
//            book.close();
//        } catch (IOException | BiffException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 保存内容到数据库
     * 如果excel文件中含有中文，在进行操作的时候，jxl会自动将xls文件转成csv文件格式，
     * 而在转换后会将中文默认转成”_”下划线，如我贴的第一张图中的数据第二列的“01期08”则会转成“01_08”,
     * 如果你想在存入数据库使用中文存入，只需要将字符”_”替换成”期”即可
     *
     * @param sheet 第一页的表对象
     */
//    private void insertExpressBeans(Sheet sheet) {
//        // 4 遍历标本的每一行
//        int rows = sheet.getRows();
////        ToastUtil.showLongToast(getContext(), "一共" + rows + "行");
//        ToastUtil.showLongToast(getActivity(), "一共" + rows + "行");
//        Log.e(TAG, "insertExpressBeans: " + rows);
//        for (int i = 1; i < rows; i++) {
//            ExpressBean expressBean = new ExpressBean();
//            expressBean.setComName(sheet.getCell(0, i).getContents());
//            expressBean.setComCode(sheet.getCell(1, i).getContents());
////            expressBean.setIntroductions(sheet.getCell(2, i).getContents());
////            expressBean.setType(sheet.getCell(3, i).getContents());
////            expressBean.setCountryCode(sheet.getCell(4, i).getContents());
//            expressBean.save();
//        }
////        for (int j = 1; j < sheet.getRows(); ++j) {
////            // 5  initDataInfo(sheet.getCell(0, j).getContents(), sheet.getCell(1, j).getContents());
////            for (int i = 0; i < sheet.getColumns(); i++) {
////
////            }
////        }
//    }

//    //这个方法是写在SQLiteOpenHelper子类里的，为了方便查看这里拿出来了
//    public void initDataInfo(String code, String value) {
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put("code", code);
//        cv.put("value", value);
//        db.insert(DATA_TABLE, null, cv);
//    }
    private void testSP() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("AA", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("BB", "XXX").commit();
        SharedPreferences sharedPreferences1 = getActivity().getApplicationContext().getSharedPreferences("AA", Context.MODE_PRIVATE);
        String bb = sharedPreferences1.getString("BB", "");
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


    @Override
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void handleEvent(CommonEvent event) {
        int status = event.getStatus();
        Log.i(TAG, "handleEvent: " + event.toString());
        switch (status) {
        }
    }

    /**
     * 显示切换的动画
     */
//    private void changeAnimator() {
//        AnimatorSet showServerSet = new AnimatorSet();
//        ObjectAnimator alphaAnimHiddeBackIv = ObjectAnimator.ofFloat(mTextView1, "alpha", 0, 1);
//        ObjectAnimator alphaAnimHiddeNextIv = ObjectAnimator.ofFloat(mTextView2, "alpha", 1, 0);
//        showServerSet.playTogether(alphaAnimHiddeBackIv, alphaAnimHiddeNextIv);
//        showServerSet.setDuration(200);
//        showServerSet.start();
//    }

}
