package com.learzhu.browser.activity;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.learzhu.browser.R;
import com.learzhu.browser.broadreceiver.ScreenBroadcastReceiver;
import com.learzhu.browser.fragment.BlankFragment;
import com.learzhu.browser.fragment.ItemFragment;
import com.learzhu.browser.utils.StatusBarUtil;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {
    private ScreenBroadcastReceiver screenBroadcastReceiver = null;
    private Context mContext = null;
    private Button lockedScreenBtn = null;
    private android.support.v4.app.FragmentTransaction mFragmentTransaction1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusTranslucent(this);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        registerScreenBroadcastReceiver();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mFragmentTransaction1 = getSupportFragmentManager().beginTransaction();
//        MainActivityFragment mainActivityFragment = new MainActivityFragment();

        BlankFragment blankFragment = new BlankFragment();
        mFragmentTransaction1.add(R.id.fragment, blankFragment);
        mFragmentTransaction1.commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                StatusBarUtil.setStatusByColor(MainActivity.this, Color.BLACK);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                ItemFragment fragment = ItemFragment.newInstance(5);
//                fragmentTransaction.replace(R.id.fragment, fragment);
//                mFragmentTransaction1.replace(R.id.fragment, fragment);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PowerManager pm = (PowerManager) this.getSystemService(Context.POWER_SERVICE);
        if (!pm.isScreenOn()) {
            PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP |
                    PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "bright");
            wl.acquire();
            wl.release();
        }
    }

    /**
     * ACTION_SCREEN_ON和ACTION_SCREEN_OFF还有ACTION_USER_PRESENT三个Action的用法，
     * 由于作为一个总结博文，当时并没有详细讲， ACTION_SCREEN_ON和ACTION_SCREEN_OFF
     * 只能通过动态注册的方式（代码内context.register和unregister），
     * 而ACTION_USER_PRESENT则是动态、静态注册两种方式都可以。
     */
    private void registerScreenBroadcastReceiver() {
        screenBroadcastReceiver = new ScreenBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);//当屏幕锁屏的时候触发
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);//当屏幕解锁的时候触发
        intentFilter.addAction(Intent.ACTION_USER_PRESENT);//当用户重新唤醒手持设备时触发
        mContext.registerReceiver(screenBroadcastReceiver, intentFilter);
        Log.i("screenBR", "screenBroadcastReceiver注册了");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
