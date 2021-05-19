package com.sakura.test_demo.api.vo.request;

public class ReflexRQVo {
    private String reflexCode;
    // 0：查询，1：新增，2：修改，3：删除
    private Integer reflexOperation;

    public String getReflexCode() {
        return reflexCode;
    }

    public void setReflexCode(String reflexCode) {
        this.reflexCode = reflexCode;
    }

    public Integer getReflexOperation() {
        return reflexOperation;
    }

    public void setReflexOperation(Integer reflexOperation) {
        this.reflexOperation = reflexOperation;
    }
}