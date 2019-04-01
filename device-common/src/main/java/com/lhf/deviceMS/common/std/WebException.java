package com.lhf.deviceMS.common.std;


import com.lhf.deviceMS.common.std.enums.WebErrCode;

/**
 * @author zuochi
 * @version v1.0.0
 * @see
 * @since 2018/7/4
 */
public class WebException extends Exception{
    public static final String DEFAULT_ERR_CODE = "500";

    private final String code;

    private final String msg;

    public WebException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public WebException(String msg) {
        super(msg);
        this.code = DEFAULT_ERR_CODE;
        this.msg = msg;
    }

    public WebException(String msg, Exception e) {
        super(e);
        this.code = DEFAULT_ERR_CODE;
        this.msg = msg;
    }

    public WebException(WebErrCode code) {
        super(code.getMsg());
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public WebException(Exception e) {
        super(e);
        this.code = DEFAULT_ERR_CODE;
        this.msg = e.getLocalizedMessage();
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
