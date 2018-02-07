package com.learzhu.browser.test;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ExpressBean.java是液总汇的物流查询的类。
 *
 * @author Learzhu
 * @version 2.0.0 2018-02-06 14:06
 * @update Learzhu 2018-02-06 14:06
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class ExpressBean implements Parcelable {

    /**
     * comCode : shunfeng
     * id :
     * noCount : 1
     * noPre : 9069
     * startTime :
     */
    /**
     * 公司编码
     * 快递公司对应的编码
     */
    private String comCode;
    private String id;
    private int noCount;
    private String noPre;
    private String startTime;

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNoCount() {
        return noCount;
    }

    public void setNoCount(int noCount) {
        this.noCount = noCount;
    }

    public String getNoPre() {
        return noPre;
    }

    public void setNoPre(String noPre) {
        this.noPre = noPre;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.comCode);
        dest.writeString(this.id);
        dest.writeInt(this.noCount);
        dest.writeString(this.noPre);
        dest.writeString(this.startTime);
    }

    public ExpressBean() {
    }

    protected ExpressBean(Parcel in) {
        this.comCode = in.readString();
        this.id = in.readString();
        this.noCount = in.readInt();
        this.noPre = in.readString();
        this.startTime = in.readString();
    }

    public static final Creator<ExpressBean> CREATOR = new Creator<ExpressBean>() {
        @Override
        public ExpressBean createFromParcel(Parcel source) {
            return new ExpressBean(source);
        }

        @Override
        public ExpressBean[] newArray(int size) {
            return new ExpressBean[size];
        }
    };
}
