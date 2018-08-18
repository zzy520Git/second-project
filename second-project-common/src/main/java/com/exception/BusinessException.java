package com.exception;

import com.common.ResponseResult;

/**
 * Description：
 * 业务逻辑异常
 * @author zhouzhongyi1
 * @date 2018/8/3 14:14
 */
public class BusinessException extends RuntimeException {
    public BusinessException() {
        super("业务逻辑异常");
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(int code, String desc) {
        super(String.format("业务逻辑异常；Code:[%d], Description:[%s].", code, desc));
    }

    public static BusinessException asBusinessException() {
        return new BusinessException(ResponseResult.FAILURE, ResponseResult.FAILURE_DESC) ;
    }

    public static BusinessException rpcBusinessException() {
        return new BusinessException("调用远程服务异常，请稍后再试！") ;
    }
    public static BusinessException clientBusinessException() {
        return new BusinessException("服务异常，请稍后再试！") ;
    }
    public static BusinessException serviceBusinessException() {
        return new BusinessException("系统内部异常，请稍后再试！") ;
    }
}
