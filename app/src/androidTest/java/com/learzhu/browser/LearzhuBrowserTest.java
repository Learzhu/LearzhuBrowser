//package com.learzhu.browser;
//
//import android.test.ActivityInstrumentationTestCase2;
//import android.widget.TextView;
//
//import com.learzhu.browser.activity.ImageActivity;
//
///**
// * ${className}.java是极搜浏览器的$DES$类。
// *
// * @author Learzhu
// * @version 3.0.0 2017/8/2 17:39
// * @update Learzhu 2017/8/2 17:39
// * @updateDes
// * @include {@link }
// * @used {@link }
// */
//
//public class LearzhuBrowserTest extends ActivityInstrumentationTestCase2<ImageActivity> {
//    private ImageActivity mImageActivity;
//    private TextView mTextView;
//
//    public LearzhuBrowserTest(String pkg, Class<ImageActivity> activityClass) {
//        super(pkg, activityClass);
//    }
//
//    public LearzhuBrowserTest(Class<ImageActivity> activityClass) {
//        super(activityClass);
//    }
//
//    public LearzhuBrowserTest() {
//        super(ImageActivity.class);
//    }
//
//
//    @Override
//    protected void setUp() throws Exception {
//        super.setUp();
//        mImageActivity = getActivity();
//        mTextView = (TextView) mImageActivity.findViewById(R.id.tv_text);
//    }
//
//    public void testInit() {
//        String title = mTextView.getText().toString();
//        assertEquals(title, "200");
//    }
//}
