package com.sakura.test_demo.service;

import com.sakura.test_demo.utils.reflex.ReflexDetailBuilder;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 抽象Service - 获取application和beanMap
 *
 * @author wangjianing
 */
@Component
public class IrisContextService implements ApplicationContextAware {

    //报表接口的BeanMap
    protected Map<String, ReflexDetailBuilder> beanMap;
    /**
     * Spring 容器
     */
    protected ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }


    @PostConstruct
    private void setBeanMap(){
        // 获取所有实现接口的Bean
        Map<String, ReflexDetailBuilder> reportDetailBuilderMap = this.ctx.getBeansOfType(ReflexDetailBuilder.class);
        // 获取所有实现接口的Bean - type -> Vo
        beanMap=new HashMap<>();
        if(reportDetailBuilderMap != null && !reportDetailBuilderMap.isEmpty()){
            reportDetailBuilderMap.forEach(
                    (a,b) -> beanMap.put(b.getReflexEnum().getType(),b)
            );
        }
    }

    public Map<String, ReflexDetailBuilder> getBeanMap() {
        return beanMap;
    }
}