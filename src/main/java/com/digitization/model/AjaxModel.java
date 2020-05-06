package com.digitization.model;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class AjaxModel {
    private static final Logger logger = LoggerFactory.getLogger(AjaxModel.class);
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;

    public AjaxModel() {
    }

    public void print(Object data) {
        PrintWriter out = null;

        try {
            this.response.setCharacterEncoding("utf-8");
            this.response.setContentType("text/html;charset=utf8");
            out = this.response.getWriter();
            JSONObject e = (JSONObject)data;
            String json1 = "(" + e.toJSONString() + ")";
            System.out.println("response:" + json1);
            out.print("(" + e.toJSONString() + ")");
        } catch (Exception var8) {
            logger.error("print api result error. e={}", var8);
            JSONObject json = new JSONObject();
            json.put("success", false);
            json.put("code", "500");
            json.put("desc", "内部执行错误");
            out.print("(" + json.toJSONString() + ")");
        } finally {
            out.flush();
            out.close();
        }

    }
}
