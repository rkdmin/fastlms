package com.zerobase.fastlms.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
    
    public static String getUserAgent(HttpServletRequest request) {
        return request.getHeader("User-Agent");
    }
    
    public static String getClientIp(HttpServletRequest request){
        String ip = request.getHeader("X-FORWARDED-FOR");

        if (ip == null || ip.length() == 0) {
            ip = request.getHeader("Proxy-Client-IP");
        }


        if (ip == null || ip.length() == 0) {
            ip = request.getHeader("WL-Proxy-Client-IP");  // 웹로직
        }


        if (ip == null || ip.length() == 0) {
            ip = request.getRemoteAddr() ;
        }

        return ip;
    }

}
