package com.yuexun.utils.webutil;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理web请求的util
 * @author Wanghk
 *
 */
public class WebUtil {
	
	/**
	 * 获取请求主机IP地址，透过代理获取真实IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteIP(HttpServletRequest request) {
		String clientIP = request.getHeader("x-forwarded-for");
		if (clientIP == null || clientIP.length() == 0
				|| "unknown".equalsIgnoreCase(clientIP)) {
			clientIP = request.getHeader("Proxy-Client-IP");
		}
		if (clientIP == null || clientIP.length() == 0
				|| "unknown".equalsIgnoreCase(clientIP)) {
			clientIP = request.getHeader("WL-Proxy-Client-IP");
		}
		if (clientIP != null && clientIP.length() > 0
				&& !"unknown".equalsIgnoreCase(clientIP)) {
			String[] array = clientIP.split(",");
			for (int index = 0; index < array.length; index++) {
				if (!"unknown".equalsIgnoreCase(array[index])) {
					clientIP = array[index];
					break;
				}
			}
		}
		if (clientIP == null || clientIP.length() == 0
				|| "unknown".equalsIgnoreCase(clientIP)) {
			clientIP = request.getRemoteAddr();
		}
		return clientIP;
	}
}
