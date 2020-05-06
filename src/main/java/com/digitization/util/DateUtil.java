package com.digitization.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    public static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_TIME2 = "yyyyMMddHHmmss";

    public static String getDateStr(String formatRule) {
        SimpleDateFormat format = new SimpleDateFormat(formatRule);
        return format.format(new Date());
    }

    public static String getDateStr() {
        return getDateStr(FORMAT_TIME);
    }
}
