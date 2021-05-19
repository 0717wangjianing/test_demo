package com.sakura.test_demo.utils.enums.reflex;

import org.apache.commons.lang3.math.NumberUtils;

public enum ReflexEnum {

    /** 1001 */
    ReflexDetail_1("1"), ReflexDetail_2("2");

    // 构造方法
    private ReflexEnum(String type){
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public final boolean equals(String type) {
        if (type == null) {
            return false;
        }
        int i = this.getType().compareTo(type);
        if (i == NumberUtils.INTEGER_ZERO.intValue()) {
            return true;
        }
        return false;
    }
}