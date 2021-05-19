package com.sakura.test_demo.service.serviceImpl.reflex;

import com.sakura.test_demo.api.vo.request.ReflexDetailInfo_2;
import com.sakura.test_demo.api.vo.request.ReflexRQVo;
import com.sakura.test_demo.service.reflex.ReflexDetailInfo_2Service;
import com.sakura.test_demo.utils.enums.reflex.ReflexEnum;
import com.sakura.test_demo.utils.reflex.ReflexDetailBuilder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReflexDetailInfo_2ServiceImpl extends ReflexDetailBuilder<ReflexDetailInfo_2> implements ReflexDetailInfo_2Service {

    @Override
    public ReflexEnum getReflexEnum() {
        return ReflexEnum.ReflexDetail_2;
    }

    @Override
    public void insert(ReflexRQVo reflexRQVo){
        System.out.printf("进入ReflexDetailInfo_2ServiceImpl的insert方法" + new Date());
    }

    @Override
    public Object query(ReflexRQVo reflexRQVo){
        System.out.printf("进入ReflexDetailInfo_2ServiceImpl的query方法" + new Date());
        return null;
    }

    @Override
    public void update(ReflexRQVo reflexRQVo){
        System.out.printf("进入ReflexDetailInfo_2ServiceImpl的update方法" + new Date());

    }

    @Override
    public void delete(ReflexRQVo reflexRQVo){
        System.out.printf("进入ReflexDetailInfo_2ServiceImpl的delete方法" + new Date());

    }
}