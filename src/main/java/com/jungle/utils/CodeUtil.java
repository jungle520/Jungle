package com.jungle.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangjiang on 2019/10/26.
 */
public class CodeUtil {
    public static boolean checkVerifyCode(HttpServletRequest request) {
        String verifyCodeExpected = (String) request.getSession().getAttribute(
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        //这里相当于 request.getParameter("verifyCodeActual");
       // String verifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");
//        if (verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)) {
//            return false;
//        }
        return true;

    }
}
