package com.sakura.test_demo.utils.response;

import com.fasterxml.jackson.annotation.JsonView;
import com.sakura.test_demo.utils.group.All;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class RestReturnObjectWithTAndView<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonView({All.class})
    @ApiModelProperty(
            value = "返回状态",
            example = "success"
    )
    private String code = "fail";
    @JsonView({All.class})
    @ApiModelProperty(
            value = "返回提示信息",
            example = "返回成功"
    )
    private String message = "系统异常";
    @JsonView({All.class})
    @ApiModelProperty("返回结果对象")
    private T obj;

    public RestReturnObjectWithTAndView() {
    }

    public static <T> RestReturnObjectWithTAndView<T> generateSuccessObject(T t) {
        RestReturnObjectWithTAndView<T> returnObject = new RestReturnObjectWithTAndView();
        returnObject.setCode("success");
        returnObject.setMessage("success");
        returnObject.setObj(t);
        return returnObject;
    }

    public static <T> RestReturnObjectWithTAndView<T> generateFailedObject(String msg, T t) {
        RestReturnObjectWithTAndView<T> returnObject = new RestReturnObjectWithTAndView();
        returnObject.setCode("fail");
        returnObject.setMessage(msg);
        returnObject.setObj(t);
        return returnObject;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObj() {
        return this.obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
