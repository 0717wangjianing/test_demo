package com.sakura.test_demo.utils.reflex;


import com.sakura.test_demo.api.vo.request.ReflexRQVo;
import com.sakura.test_demo.utils.enums.reflex.ReflexEnum;

/**
 * 抽象类builder，中介必须跟当前类有关才在反射机制内
 * 父类Builder，子类必须继承父类，使用@Override使方法重写
 */
public abstract class ReflexDetailBuilder<Vo extends ReflexRQVo> {

    /** 获取台账类型 **/
    public abstract ReflexEnum getReflexEnum();

    public void insert(ReflexRQVo reflexRQVo){

    }

    public Object query(ReflexRQVo reflexRQVo){
        return null;
    }

    public void update(ReflexRQVo reflexRQVo){

    }

    public void delete(ReflexRQVo reflexRQVo){

    }
}