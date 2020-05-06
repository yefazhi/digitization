package com.digitization.common;

import com.alibaba.fastjson.JSONObject;
import com.digitization.enums.ReasonCodeEnum;

import java.io.Serializable;

public class JsonResult extends JSONObject implements Serializable {
    private static final long serialVersionUID = 1L;

    public JsonResult() {
    }

    public static JSONObject getSuccess() {
        JSONObject json = new JSONObject();
        json.put("success", true);
        json.put("code", "200");
        return json;
    }

    public static JSONObject getError(String desc) {
        JSONObject json = new JSONObject();
        json.put("success", false);
        json.put("desc", desc);
        return json;
    }

    public static JSONObject getError(ReasonCodeEnum reasonCodeEnum) {
        JSONObject json = new JSONObject();
        json.put("success", false);
        json.put("desc", reasonCodeEnum.getDesc());
        json.put("code", reasonCodeEnum.getCode());
        return json;
    }

    public static JSONObject getError(String code, String desc) {
        JSONObject json = new JSONObject();
        json.put("success", false);
        json.put("code", code);
        json.put("desc", desc);
        return json;
    }

    public static JSONObject getSuccess(Object data) {
        JSONObject json = new JSONObject();
        json.put("success", true);
        json.put("code", "200");
        json.put("data", data);
        return json;
    }

    public boolean isSuccess() {
        boolean suc = (Boolean)this.get("success");
        return suc;
    }
}

