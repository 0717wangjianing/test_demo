package com.sakura.test_demo.service;

import com.alibaba.fastjson.JSONObject;
import com.sakura.test_demo.api.vo.request.ReflexRQVo;

public interface ReflexService {

    /**
     * 反射大纲
     * */
    public Object reflexInfo(JSONObject jsonObject);
}