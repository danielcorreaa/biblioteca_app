package com.biblioteca;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class ConfigurationInterception extends HandlerInterceptorAdapter{
	
	private static final Logger	logger = LoggerFactory.getLogger(ConfigurationInterception.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String x = request.getMethod();
	    logger.info(x + "intercepted");
		return true;
	}

}
