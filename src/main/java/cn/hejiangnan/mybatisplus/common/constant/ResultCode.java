package cn.hejiangnan.mybatisplus.common.constant;

/**
 * @ClassName: ResultCode
 * @Description: 统一返回状态码
 * @Author: hejiangnan
 * @Date: 2020/8/3
 */
public enum ResultCode {

    // 成功
    SUCCESS(1000, "success"),
    PARAM_ERROR(2001, "parameter error"),
    SYS_ERROR(2002, "system error"),
    NAMESPACE_NOT_FOUND(2003, "namespace not found"),
    NODE_NOT_EXIST(3002, "node not exist"),
    NODE_ALREADY_EXIST(3003, "node already exist"),
    UNKNOWN_ERROR(9999, "unknown error");

    private int code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

}
