package cn.hejiangnan.mybatisplus.entity.dto;

import java.io.Serializable;

import cn.hejiangnan.mybatisplus.common.constant.ResultCode;
import lombok.Data;

/**
 * @ClassName: Result
 * @Description: 统一响应
 * @Author: hejiangnan
 * @Date: 2020/8/3
 */
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = -3948389268046368059L;
    private Integer code;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        if (data == null) {
            return Result.failure(ResultCode.NODE_NOT_EXIST, "找不到资源");
        } else {
            result.setData(data);
            return result;
        }
    }

    public static Result failure(Integer resultCode, String msg) {
        Result result = new Result();
        result.setCode(resultCode);
        result.setMsg(msg);
        return result;
    }

    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.msg();
    }
}
