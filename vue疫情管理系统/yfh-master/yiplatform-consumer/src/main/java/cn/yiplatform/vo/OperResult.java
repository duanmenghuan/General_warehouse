package cn.yiplatform.vo;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class OperResult<T> implements Serializable {

    /**
     * 操作成功 1
     * 意义固定
     */
    public static int OPER_SUCCESS = 1;

    /**
     * 操作失败 0
     */
    public static int OPER_FAILURE = 0;

    private String code;

    /**
     * 操作结果代码
     */
    private int status;

    /**
     * 操作结果信息
     */
    private String msg = StringUtils.EMPTY;

    /**
     * 操作结果对象
     */
    private transient T data;

    /*********Constructor***************/
    public OperResult(int status) {
        this.status = OPER_SUCCESS;
    }

    public OperResult(boolean status, String msg) {
        this.status = status ? OPER_SUCCESS : OPER_FAILURE;
        this.msg = msg;
    }

    public OperResult(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public OperResult(boolean status, String msg, T data) {
        this.status = status ? OPER_SUCCESS : OPER_FAILURE;
        this.msg = msg;
        this.data = data;
    }

    public OperResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public OperResult(int status, String code,  String msg, T data) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public OperResult(boolean status, String code,  String msg, T data) {
        this.code = code;
        this.status = status ? OPER_SUCCESS : OPER_FAILURE;
        this.msg = msg;
        this.data = data;
    }

    /*****************Getter Setter***********************/
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 返回是否成功
     * @return true 成功
     */
    public boolean success() {
        return this.status == OPER_SUCCESS;
    }

    @Override
    public String toString() {
        return "OperResult{" +
                "code='" + code + '\'' +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + String.valueOf(data) +
                '}';
    }
}
