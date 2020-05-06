package com.digitization.enums;

public enum ReasonCodeEnum {
    AUTH_ERROR("000", "认证失败"),
    AUTH_FAILED("001", "用户认证失败"),
    AUTH_EXPIRED("002", "授权过期"),
    PASSWORD_AUTH_FAILED("003", "用户密码认证失败"),
    PARAM_ERROR("100", "非法参数"),
    PARAM_NULL_ERROR("101", "参数不能为空"),
    PARAM_DATA_TYPE_ERROR("102", "参数类型不正确"),
    PARAM_OVER_MAX_LEN("103", "参数超过最大长度"),
    PARAM_FORMAT_ERROR("104", "参数格式不正确"),
    QUERY_INTERVAL_INVALID("105", "参数范围不正确"),
    PARAM_DATA_NOT_EXIST_ERROR("106", "枚举值不存在"),
    EXPORT_REPORT_NUMBER_ERROR("107", "报告导出数量太大"),
    PRIMARYCODE_REPEAT("108", "接口录入贷前报告重复"),
    PARAM_POSTLOAN_CODE_NOT_EXIST("109", "贷后添加监控编号不存在"),
    POSTLOAN_RISK_SCAN_NOT_COMPLETE("110", "当天扫描还未完成"),
    NO_CONTENT("204", "无响应"),
    PARTIAL_CONTENT("206", "部分信息"),
    REPEAT_CONTENT("207", "信息疑似重复录入"),
    UNAVAILABLE("300", "服务不可用"),
    NOT_BUY_SERVICE("301", "流量未购买"),
    NOT_ALLOWED("302", "服务已被禁用"),
    FLOW_POOR("303", "流量已用完"),
    OUT_OF_SERVICE_DATE("304", "流量已过期"),
    FLOW_NOT_ENOUGH("304", "流量不足"),
    BAD_REQUIRED("400", "找不到"),
    UNAUTHORIZED("401", "未授权"),
    PAYMENT_REQUIRED("402", "需要付款"),
    FORBIDDEN("403", "禁止访问"),
    NOT_FOUND("404", "找不到资源"),
    METHOD_NOT_ALLOWED("405", "不允许的请求方法"),
    CSRFTOKEN("408", "csrftoken校验失败"),
    GONE("410", "授权已过期"),
    UNSUPPORTED_MEDIA_TYPE("415", "不支持的媒体类型"),
    INTERNAL_ERROR("500", "内部执行错误"),
    NOT_IMPLEMENTED("501", "未执行"),
    BAD_GATEWAY("502", "错误网关"),
    SERVICE_UNAVAILABLE("503", "无法获得服务"),
    TIMEOUT("600", "超时"),
    CASSANDRA_TIMEOUT("701", "cassandra查询超时"),
    POLICY_EXECUTE_TIMEOUT("601", "异步执行"),
    NO_RESULT("666", "查无结果"),
    OTHERS("700", "业务逻辑错误");

    private String code;
    private String desc;

    private ReasonCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return this.desc;
    }

    private void setDesc(String desc) {
        this.desc = desc;
    }

    public String toString() {
        return this.code + ":" + this.desc;
    }
}
