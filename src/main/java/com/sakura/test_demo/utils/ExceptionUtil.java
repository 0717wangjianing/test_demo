package com.sakura.test_demo.utils;

import com.sakura.test_demo.utils.convenient.BizException;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {
    public ExceptionUtil() {
    }

    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        String var3;
        try {
            try {
                t.printStackTrace(pw);
            } catch (Exception var7) {
            }

            var3 = sw.toString();
        } finally {
            pw.close();
        }

        return var3;
    }

    public static String getPromptMessage(Throwable t) {
        return t instanceof BizException ? t.getMessage() : "请求失败,请联系系统管理员";
    }
}