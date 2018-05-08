package com.xrom.server.response;


import com.xrom.server.code.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

import static com.xrom.server.code.ResponseCode.SUCCESSFUL;
import static com.xrom.server.code.ResponseCode.UNDEFINED;

/**
 * 封装返回的json数据
 * @author XRom
 * @date 2018-02-09 10-23
 */
@AllArgsConstructor
@Getter
public class WebResponse implements Serializable {

    private int code;

    private Object data;

    private String msg;

    private static WebResponse of(int code, Object data, String msg) {
        return new WebResponse(code, data, msg);
    }

    public static WebResponse success() {
        return of(SUCCESSFUL.codeOf(), null, SUCCESSFUL.msgOf());
    }

    public static WebResponse success(Object data) {
        return of(SUCCESSFUL.codeOf(), data, SUCCESSFUL.msgOf());
    }

    public static WebResponse error() {
        return of(UNDEFINED.codeOf(), null, UNDEFINED.msgOf());
    }

    public static WebResponse error(String msg) {
        return of(500, null, msg);
    }

    public static WebResponse error(ResponseCode code) {
        return of(code.codeOf(), null, code.msgOf());
    }
}

