package com.learzhu.browser.event;

/**
 * CommentEvent.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2019-01-16 13:20
 * @update Learzhu 2019-01-16 13:20
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class CommonEvent {
    //登录的状态描述
    private String mMsg;
    //登录的状态值
    private int status;

    public CommonEvent(String msg, int status) {
        mMsg = msg;
        this.status = status;
    }

    public CommonEvent(String msg) {
        mMsg = msg;
    }

    public CommonEvent(int loginSuccess) {
    }

    public String getMsg() {
        return mMsg;
    }

    public void setMsg(String msg) {
        mMsg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CommonEvent{" +
                "mMsg='" + mMsg + '\'' +
                ", status=" + status +
                '}';
    }
}
