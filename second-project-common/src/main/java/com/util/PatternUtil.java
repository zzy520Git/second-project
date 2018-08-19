package com.util;

import java.util.regex.Pattern;

/**
 * Description:
 *
 * @author zhouzhongyi
 * Date: 2018/8/19 1:02
 */
public class PatternUtil {
    /**
     * 校验用户名(字母开头，由下划线、字母和数字组成，长度为6-16个字符)
     */
    private static final String USERNAME_PATTERN_STRING = "^[a-zA-Z][a-zA-Z0-9_]{5,15}$" ;
    /**
     * 校验密码，通常在前端就会加密密码(可由!@#$%&*-_以及字母和数字组成)
     */
    private static final String PASSWORD_PATTERN_STRING = "^[a-zA-Z0-9_!@#$%&*-]{6,}$" ;
    private static final String EMAIL_PATTERN = "以后再研究" ;
    private static final String PHONE_PATTERN = "以后再研究" ;
    private static final String IDCARD_PATTERN = "以后再研究" ;

    private static final Pattern USERNAME_PATTERN = Pattern.compile(USERNAME_PATTERN_STRING) ;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_PATTERN_STRING) ;

    public static boolean checkUsernamePattern(String username) {
        return (username==null) ? false : USERNAME_PATTERN.matcher(username).matches() ;
        //input表单值传入后台自动trim，即使不传值(不输入值)也不为空，是空字符串""
        //注意：前端输入什么值，前端的表单值依然是什么值，只是传入后台会自动trim
    }
    public static boolean checkPasswordPattern(String password) {
        return (password==null) ? false : PASSWORD_PATTERN.matcher(password).matches() ;
        //input表单值传入后台自动trim，即使不传值(不输入值)也不为空，是空字符串""
    }

    /**
     * 前端校验方法
     * var regExp = /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/ ;
     * var username = "hfasjdf" ;
     * var bool = regExp.test(username) ;
     */

}
