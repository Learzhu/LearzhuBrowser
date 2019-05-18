package com.learzhu.browser.getui;

/**
 * PushMsg.java  是液总汇的$DES$类。
 *
 * @author kk
 * @version 2.0.0 2018/4/17 14:26
 * @update kk 2018/4/17 14:26
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class PushMsg {

    /**
     * {
     * "sendType" : "ADVERT_BACK_CAPTIAL"
     * "content" : "【广告积分退回】您的广告位审核未通过！广告积分退回"
     * }
     *
     * 删除附加字段
     */

    private String sendType;
    private String content;

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
