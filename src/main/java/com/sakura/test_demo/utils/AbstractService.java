package com.sakura.test_demo.utils;

import com.sakura.test_demo.service.IrisContextService;
import com.sakura.test_demo.utils.reflex.ReflexDetailBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 抽象类
 */
public abstract class AbstractService {

    @Autowired
    private IrisContextService irisContextService;

    /**
     * 获取所有实现接口的Bean
     *
     * @return
     */
    public Map<String, ReflexDetailBuilder> getBeanMap() {
        return irisContextService.getBeanMap();
    }
}