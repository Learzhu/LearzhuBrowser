package com.learzhu.browser.litepal.bean;

import org.litepal.crud.DataSupport;

/**
 * ExpressBean.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2018-05-30 10:46
 * @update Learzhu 2018-05-30 10:46
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class ExpressBean extends DataSupport {
    // String	是	要查询的快递公司代码，不支持中文，对应的公司代码见
    //     *              《API URL 所支持的快递公司及参数说明》和《支持的国际类快递及参数说明》。
    //     *              如果找不到您所需的公司，请发邮件至 kuaidi@kingdee.com 咨询（大小写不敏感）

    /**
     * 公司编码
     * 公司名称
     * 说明
     * 类型
     * 国家编码
     */
    private String comName;
    private String comCode;
    private String introductions;
    private String type;
    private String countryCode;

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getIntroductions() {
        return introductions;
    }

    public void setIntroductions(String introductions) {
        this.introductions = introductions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public ExpressBean() {
    }
}
