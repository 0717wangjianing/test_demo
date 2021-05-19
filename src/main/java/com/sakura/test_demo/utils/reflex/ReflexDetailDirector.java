package com.sakura.test_demo.utils.reflex;

import com.sakura.test_demo.api.vo.request.ReflexRQVo;
import org.apache.commons.lang3.StringUtils;

/**
 * 反射明细，类似Vo
 */
public class ReflexDetailDirector {

    private ReflexDetailBuilder reflexDetailBuilder;

    public ReflexDetailBuilder getReflexDetailBuilder() {
        return reflexDetailBuilder;
    }

    public void setReflexDetailBuilder(ReflexDetailBuilder reflexDetailBuilder) {
        this.reflexDetailBuilder = reflexDetailBuilder;
    }

    public void insert(ReflexRQVo reflexRQVo){
        this.checkParam(reflexRQVo);
        reflexDetailBuilder.insert(reflexRQVo);
    }

    public Object query(ReflexRQVo reflexRQVo){
        this.checkParam(reflexRQVo);
        return reflexDetailBuilder.query(reflexRQVo);
    }

    public void update(ReflexRQVo reflexRQVo){
        this.checkParam(reflexRQVo);
        reflexDetailBuilder.update(reflexRQVo);
    }

    public void delete(ReflexRQVo reflexRQVo){
        this.checkParam(reflexRQVo);
        reflexDetailBuilder.delete(reflexRQVo);
    }

    private void checkParam(ReflexRQVo reflexRQVo){
        if(reflexRQVo == null){
            // 错误异常
            throw new Error();
        }
        if(StringUtils.isBlank(reflexRQVo.getReflexCode()) || null == reflexRQVo.getReflexOperation()){
            throw new Error();
        }
    }
}