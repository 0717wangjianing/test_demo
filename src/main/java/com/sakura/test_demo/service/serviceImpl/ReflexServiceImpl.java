package com.sakura.test_demo.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sakura.test_demo.api.vo.request.ReflexRQVo;
import com.sakura.test_demo.service.ReflexService;
import com.sakura.test_demo.utils.AbstractService;
import com.sakura.test_demo.utils.reflex.ReflexDetailBuilder;
import com.sakura.test_demo.utils.reflex.ReflexDetailDirector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;

@Service
public class ReflexServiceImpl extends AbstractService implements ReflexService {

    private ReflexDetailDirector reflexDetailDirector;

    public Object reflexInfo(JSONObject jsonObject) {
        // 根据前段传入参数强转成后端固定Vo
        ReflexRQVo reflexRQVo = jsonObject.toJavaObject(ReflexRQVo.class);
        // 对象转换成JSONObject
        JSONObject js = (JSONObject) JSONObject.toJSON(reflexRQVo);
        // 字符串转对象
        String jsonCode = JSONObject.toJSONString(reflexRQVo);
        ReflexRQVo reflexRQVos = JSONObject.parseObject(jsonCode,ReflexRQVo.class);
        String type = reflexRQVo.getReflexCode();
        Integer operation = reflexRQVo.getReflexOperation() == null ? 0 : reflexRQVo.getReflexOperation() ;

        // 根据type类型，获取对应的所有Service类型
        ReflexDetailDirector reflexDetailDirector = new ReflexDetailDirector();
        // 获取枚举类中所有Builder类型
        ReflexDetailBuilder reflexDetailBuilder = this.getReflexDetailBuilderByType(type);
        reflexDetailDirector.setReflexDetailBuilder(reflexDetailBuilder);

        ReflexRQVo ReflexDetail = this.getReflexDetailTemplateVoByType(jsonObject,reflexDetailDirector);
        switch (operation){
            case 0:
                reflexDetailDirector.query(ReflexDetail);
                break;
            case 1:
                reflexDetailDirector.insert(ReflexDetail);
                break;
            case 2:
                reflexDetailDirector.update(ReflexDetail);
                break;
            case 3:
                reflexDetailDirector.delete(ReflexDetail);
                break;
        }
        return null;
    }

    /**
     * 获取对应的Vo类型
     * @param jSONObject
     * @param reportDetailDirector
     * @return
     */
    private ReflexRQVo getReflexDetailTemplateVoByType(JSONObject jSONObject, ReflexDetailDirector reportDetailDirector) {
        return (ReflexRQVo)jSONObject.toJavaObject(getClassType(reportDetailDirector.getReflexDetailBuilder()));
    }

    /**
     * 根据type类型获取Bean
     *
     * @return
     */
    public ReflexDetailBuilder getReflexDetailBuilderByType(String type) {
        if (type == null)
            return null;
        // BeanMap获取所有Service类型，get取当前要进入的Service地址
        return getBeanMap().get(type);
    }



    /**
     * 根据报表明细获取classType
     */
    public Class getClassType(ReflexDetailBuilder reportDetailBuilder){
        if (reportDetailBuilder != null) {
            //reportDetailBuilder.getClass() 类的calss
            //reportDetailBuilder.getClass().getGenericSuperclass() 父类的泛型class
            boolean isParameterizedType = ParameterizedType.class
                    .isAssignableFrom(reportDetailBuilder.getClass().getGenericSuperclass().getClass());
            Class<?> clazz = null;
            if (isParameterizedType) {
                //未代理
                clazz = (Class<?>) ((ParameterizedType) reportDetailBuilder.getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
            } else {
                //cglib 代理后
                clazz = (Class<?>) ((ParameterizedType) reportDetailBuilder.getClass().getSuperclass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
            }
            return clazz;
        }
        return null;
    }
}