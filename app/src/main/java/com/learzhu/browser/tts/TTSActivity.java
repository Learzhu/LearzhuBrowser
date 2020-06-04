package com.learzhu.browser.tts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.learzhu.browser.R;
import com.learzhu.browser.utils.ToastUtil;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTSActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    @BindView(R.id.et_tts_content)
    EditText mContentEt;

    private TextToSpeech mTextToSpeech;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, TTSActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);
        ButterKnife.bind(this);
        mTextToSpeech = new TextToSpeech(this, this);
    }

    @OnClick({R.id.tts_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tts_btn:
                String content = mContentEt.getText().toString();
                mTextToSpeech.speak(content, TextToSpeech.QUEUE_FLUSH, null);
                break;
        }
    }

    /**
     * 初始化TTS
     *
     * @param status
     */
    @Override
    public void onInit(int status) {
        // 判断是否转化成功
        if (status == TextToSpeech.SUCCESS) {
            //默认设定语言为中文，原生的android貌似不支持中文。
            int result = mTextToSpeech.setLanguage(Locale.CHINESE);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                ToastUtil.showLongToast(this, "不支持");
            } else {
                //不支持中文就将语言设置为英文
                mTextToSpeech.setLanguage(Locale.US);
            }
        }
    }
}
