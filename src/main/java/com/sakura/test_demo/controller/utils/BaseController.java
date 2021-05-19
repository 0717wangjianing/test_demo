package com.sakura.test_demo.controller.utils;

import com.sakura.test_demo.utils.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(super.getClass());

    public BaseController() {
    }

    protected String getStackTrace(Throwable e) {
        return ExceptionUtil.getStackTrace(e);
    }
}