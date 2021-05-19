package com.sakura.test_demo.service.serviceImpl.reflex;

import com.sakura.test_demo.api.vo.request.ReflexDetailInfo_1;
import com.sakura.test_demo.api.vo.request.ReflexRQVo;
import com.sakura.test_demo.service.reflex.ReflexDetailInfo_1Service;
import com.sakura.test_demo.utils.enums.reflex.ReflexEnum;
import com.sakura.test_demo.utils.reflex.ReflexDetailBuilder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReflexDetailInfo_1ServiceImpl extends ReflexDetailBuilder<ReflexDetailInfo_1> implements ReflexDetailInfo_1Service {

    @Override
    public ReflexEnum getReflexEnum() {
        return ReflexEnum.ReflexDetail_1;
    }

    @Override
    public void insert(ReflexRQVo reflexRQVo){
        System.out.printf("进入ReflexDetailInfo_1ServiceImpl的insert方法" + new Date());
    }

    @Override
    public Object query(ReflexRQVo reflexRQVo){
        System.out.printf("进入ReflexDetailInfo_1ServiceImpl的query方法" + new Date());
        return null;
    }

    @Override
    public void update(ReflexRQVo reflexRQVo){
        System.out.printf("进入ReflexDetailInfo_1ServiceImpl的update方法" + new Date());

    }

    @Override
    public void delete(ReflexRQVo reflexRQVo){
        System.out.printf("进入ReflexDetailInfo_1ServiceImpl的delete方法" + new Date());

    }
}