package com.itheima.mall.common;

import java.io.Serializable;
import java.util.Objects;

/**
 * 用于封装后端返回前端数据对象
 */
public class Result implements Serializable {
    private boolean flag;//后端返回结果正常为true，发生异常返回false
    private Object data;//后端返回结果数据对象
    private String msg;//发生异常的错误消息

    //无参构造方法
    public Result() {
    }
    public Result(boolean flag) {
        this.flag = flag;
    }
    /**
     * 有参构造方法
     * @param flag
     * @param msg
     */
    public Result(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }
    /**
     * 有参构造方法
     * @param flag
     * @param data
     * @param msg
     */
    public Result(boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
