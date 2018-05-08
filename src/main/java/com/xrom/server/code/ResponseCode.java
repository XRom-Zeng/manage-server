package com.xrom.server.code;

/**
 * @author XRom
 * @date 2018-02-09 10-25
 */
public enum ResponseCode {

    //全局
    SUCCESSFUL(200, "请求成功"),
    NO_HANDLER_FOUND(404, "请求路径未找到"),
    UNKNOWN_ACCOUNT(500, "用户不存在"),
    INCORRECT_CREDENTIALS(500, "用户密码错误"),

    UNDEFINED(0xFFFF, "未知异常");

    private Integer code;
    private String msg;

    ResponseCode(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer codeOf(){
        return this.code;
    }

    public String msgOf(){
        return this.msg;
    }

    public static ResponseCode get(int value) {
        for (ResponseCode code : values()) {
            if (code.codeOf() == value)
                return code;
        }
        return null;
    }
}
