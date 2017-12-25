package com.learzhu.browser.test;

import com.learzhu.browser.utils.DateUtil;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CustomerDate.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2017/12/25 12:52
 * @update Learzhu 2017/12/25 12:52
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class CustomerDate extends Date {
    //  @Override
    public String toString() {
        String formatShortDate = DateUtil.getFormatShortDate(this);
        return formatShortDate.substring(0, 10);
    }

    public static Date getFormatShortDate2() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(0);
        Date datetime = formatter.parse(dateString, pos);
        java.sql.Timestamp ts = null;
        if (datetime != null) {
            ts = new java.sql.Timestamp(datetime.getTime());
        }
        return ts;
    }


}
