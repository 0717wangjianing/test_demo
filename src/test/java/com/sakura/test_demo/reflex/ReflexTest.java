package com.sakura.test_demo.reflex;

import com.alibaba.fastjson.JSONObject;
import com.sakura.test_demo.api.vo.request.ReflexRQVo;
import com.sakura.test_demo.controller.reflex.ReflexController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * 不启动项目直接测试方法的话可以写测试类，例子如下：
 * */
@SpringBootTest
public class ReflexTest {

    @Autowired
    private ReflexController reflexController;

    /**
     * 这是调用ReflexDetail_1Service内的query方法
     * */
    @Test
    void reflexTest1() {
        ReflexRQVo reflexRQVo = new ReflexRQVo();
        reflexRQVo.setReflexCode("1");
        reflexRQVo.setReflexOperation(0);
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(reflexRQVo));
        reflexController.reflexInfo(jsonObject);
    }


    /**
     * 这是调用ReflexDetail_2Service内的insert方法
     * */
    @Test
    void reflexTest2() {
        ReflexRQVo reflexRQVo = new ReflexRQVo();
        reflexRQVo.setReflexCode("2");
        reflexRQVo.setReflexOperation(1);
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(reflexRQVo));
        reflexController.reflexInfo(jsonObject);
    }
}