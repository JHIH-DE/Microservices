package com.amigoscode.customer.interceptor;

import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch.qos.logback.classic.Logger;
import java.util.UUID;

/**
 * 日誌攔截器組件，在輸出日誌中加上sessionId
 *
 * @author @author jason.li
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {

  private static final Logger logger = (Logger) LoggerFactory.getLogger(SessionInterceptor.class);

  private final static String SESSION_KEY = "sessionId";

  @Override
  public boolean preHandle
      (HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    String token = request.getSession().getId();
    MDC.put(SESSION_KEY,token);
    logger.info("Pre Handle method is Calling");
    return true;
  }
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler, ModelAndView modelAndView) throws Exception {
    logger.info("Post Handle method is Calling");
  }
  @Override
  public void afterCompletion
      (HttpServletRequest request, HttpServletResponse response, Object
          handler, Exception exception) throws Exception {
    MDC.remove(SESSION_KEY);
    logger.info("Request and Response is completed");
  }
}