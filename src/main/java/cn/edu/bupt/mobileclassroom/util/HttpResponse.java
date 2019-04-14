package cn.edu.bupt.mobileclassroom.util;

public class HttpResponse {
    private String msg;
    private Integer code;
    private Object data;

    {
        msg = "success";
    }

    public HttpResponse(Object data) {
        this.code = 200;
        this.data = data;
    }

    public HttpResponse(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
