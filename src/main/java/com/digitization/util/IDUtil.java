package com.digitization.util;

import org.apache.commons.lang3.StringUtils;

public class IDUtil {

    public static String generateId(String prefix) {
        String id = DateUtil.getDateStr(DateUtil.FORMAT_TIME2);
        if (StringUtils.isBlank(prefix)) {
            return id;
        }
        return prefix+id;
    }
}
