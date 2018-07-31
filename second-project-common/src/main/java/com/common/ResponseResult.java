package com.common;

import lombok.Getter;

/**
 * Description:
 *
 * @author zhouzhongyi
 * Date: 2018/7/29 9:06
 */
public class ResponseResult<T> {
    //code
    public static final int SUCCESS = 0;
    public static final int FAILURE = 1;
    public static final int PARAM_EMPTY = 2;
    public static final int PARAM_ERROR = 3;
    //desc
    public static final String SUCCESS_DESC = "操作成功";
    public static final String FAILURE_DESC = "系统异常，请稍后再试";
    public static final String PARAM_EMPTY_DESC = "参数不能为空";
    public static final String PARAM_ERROR_DESC = "参数异常";
    public static final String DATA_UPEATED_DESC = "该数据已更新，请刷新后重试";
    public static final String NO_OPERATE_AUTH = "操作权限不够";

    //field
    @Getter
    private int code ;
    public ResponseResult setCode(int code) {
        this.code = code ;
        return this ;
    }

    @Getter
    private String desc ;
    public ResponseResult setDesc(String desc) {
        this.desc = desc ;
        return this ;
    }

    @Getter
    private T value ;
    public ResponseResult setValue(T value) {
        this.value = value ;
        return this ;
    }

    public ResponseResult() {
    }
    public ResponseResult(int code, String desc) {
        this.code = code ;
        this.desc = desc ;
    }
    public ResponseResult(int code, String desc, T value){
        this.code = code;
        this.desc = desc;
        this.value = value;
    }

    public static ResponseResult newInstance(){
        return new ResponseResult();
    }
    public static ResponseResult success(){
        return new ResponseResult(SUCCESS, SUCCESS_DESC);
    }
    public static ResponseResult failure(){
        return new ResponseResult(FAILURE, FAILURE_DESC);
    }
    public static ResponseResult paramEmpty(){
        return new ResponseResult(PARAM_EMPTY, PARAM_EMPTY_DESC);
    }
    public static ResponseResult dataUpdated(){
        return new ResponseResult(FAILURE, DATA_UPEATED_DESC);
    }
    public static ResponseResult authError(){
        return new ResponseResult(FAILURE, NO_OPERATE_AUTH);
    }
    public static ResponseResult paramError(){
        return new ResponseResult(PARAM_ERROR, PARAM_ERROR_DESC);
    }

}
