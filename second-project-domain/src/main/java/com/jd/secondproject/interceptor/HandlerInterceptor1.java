package com.jd.secondproject.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 *
 * @author zhouzhongyi
 * @date 2018/7/26 23:20
 */
public class HandlerInterceptor1 implements HandlerInterceptor {
    //进入 Handler方法之前执行
    //用于身份认证、身份授权
    //比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        //return false表示拦截，不向下执行
        //return true表示放行
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);
//        if(requestURI.indexOf("如果是公开地址")>0) {
//            //放行
//            return true ;
//        }
        //如果单点已登录
        if(true) {
            //保存登录信息，并放行
            return true;
        } else {
            //跳转到登录页面
            try {
                request.getRequestDispatcher("/model/toIndex").forward(request, response);
            } catch (Exception e) {

            }
        }
        return true ;
    }

    //进入Handler方法之后，返回modelAndView之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav) {

    }

    //执行Handler完成执行此方法
    //应用场景：统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e){

    }
}
