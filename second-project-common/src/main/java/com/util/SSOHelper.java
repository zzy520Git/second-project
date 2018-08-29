package com.util;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * DATE： 2018/8/28 19:58
 */
@Getter
@Setter
public class SSOHelper {
    private static final Logger logger = LoggerFactory.getLogger(SSOHelper.class) ;

    private String tokenKey = "sso.zzy.com" ;
    private String loginUrl = "http://sso.zzy.com/sso/login" ;
    private String domain = ".zzy.com" ;
    private String excludePath = "" ;
    private int cacheSize = 10;
    private boolean ssoEnabled = false ;

    //不支持依赖注入
    private List<String> excludePathCache;
    private Map<String, String> loginCache ;

    /**
     * 得到请求的客户端IP地址
     * @param request
     * @return
     */
    public String getRemoteIP(HttpServletRequest request) {
        String ip = request.getHeader("J-Forwarded-For");
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            logger.info("request from client remoteIP={}!", ip);
            return ip;
        } else {
            ip = request.getHeader("X-Forwarded-For");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            if (ip != null) {
                int position = ip.indexOf(",");
                if (position > 0) {
                    ip = ip.substring(0, position);
                }
            }
            logger.info("request from client remoteIP={}!", ip);
            return ip;
        }
    }

    public void logout(HttpServletResponse response) {
        logger.info("client is logout!");
        Cookie cookie = new Cookie(tokenKey,null);
        if (domain != null && !"".equals(domain.trim())) {
            cookie.setDomain(domain);
        }
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public String getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies() ;
        if(cookies != null && cookies.length>0) {
            for(Cookie cookie : cookies) {
                if(name.equals(cookie.getName())) {
                    logger.info("Cookie name={},value={}!", name, cookie.getValue());
                    return cookie.getValue() ;
                }
            }
        }
        return null ;
    }

    public void toLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
            response.setStatus(401);
            response.setHeader("Location", this.getSSOLoginUrl(request));
        } else {
            String ssoLoginUrl = this.getSSOLoginUrl(request) ;
            logger.info("to ssoLoginUrl={}!", ssoLoginUrl);
            response.sendRedirect(ssoLoginUrl);
        }
    }

    public void setCookie(HttpServletResponse response, String name, String value, int maxAge, String domain) {
        if (name != null) {
            Cookie cookie = new Cookie(name, value);
            if (StringUtils.isNotBlank(domain)) {
                cookie.setDomain(domain);
            } else if(StringUtils.isNotBlank(this.domain)) {
                cookie.setDomain(this.domain);
            }
            cookie.setPath("/");
            cookie.setMaxAge(maxAge);
            response.addCookie(cookie);
        }
    }

    private String getSSOLoginUrl(HttpServletRequest request) {
        //TODO
        return this.loginUrl ;
    }

    @PostConstruct
    private void init() {
        logger.info("init excludePath={}!", this.excludePath);
        if(StringUtils.isNotBlank(this.excludePath)) {
            this.excludePathCache = new ArrayList<>();
            String[] path = excludePath.split(",");
            for(String p : path) {
                excludePathCache.add(p.trim()) ;
            }
        }
        this.loginCache = Collections.synchronizedMap(new LinkedHashMap<String, String>(this.cacheSize, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return this.size() > SSOHelper.this.cacheSize;
            }
        });
        logger.info("init loginCache finished!");
    }

}
