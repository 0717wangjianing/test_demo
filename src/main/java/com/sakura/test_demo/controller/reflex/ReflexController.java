package com.sakura.test_demo.controller.reflex;

import com.alibaba.fastjson.JSONObject;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.sakura.test_demo.api.vo.request.ReflexRQVo;
import com.sakura.test_demo.controller.utils.BaseController;
import com.sakura.test_demo.service.ReflexService;
import com.sakura.test_demo.utils.response.RestReturnObjectWithTAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName reflexController
 * @Description
 * @Author wangjianing
 * @Date 2021/05/18
 * @Version 1.0
 */
@RestController
@Api(value = "反射代码", tags = "反射代码")
@ApiSupport(author = "wangjianing", order = 1)
public class ReflexController extends BaseController {

    @Autowired
    private ReflexService reflexService;

    @ApiOperation(value = "【web】反射根据参数匹配对应方法类", notes = "reflexInfo")
    @ApiOperationSupport(author = "wangjianing", order = 1)
    @RequestMapping(value = "/v1/reflex/reflexInfo", method = RequestMethod.POST)
    public RestReturnObjectWithTAndView<Object> reflexInfo(@RequestBody JSONObject jsonObject) {
        return RestReturnObjectWithTAndView.generateSuccessObject(reflexService.reflexInfo(jsonObject));
    }
}