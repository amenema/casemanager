package com.la.common.logger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author: amen
 * @date: 2019-08-21
 */
@Slf4j
public class ReqLogInterceptor extends HandlerInterceptorAdapter {

    private static final String REQ_TIME = "req_time";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long start = System.currentTimeMillis();
        String method = request.getMethod();
        String path = getPath(request);
        request.setAttribute(REQ_TIME, start);
        log.info("req_start: method: {}, path: {}", method, path);
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String method = request.getMethod();
        String path = getPath(request);
        long startTime = Long.valueOf(request.getAttribute(REQ_TIME).toString());
        log.info("req_end: method: {}, path: {}, status: {}, consuming: {}ms", method, path, response.getStatus(), System.currentTimeMillis() - startTime);

        super.afterCompletion(request, response, handler, ex);
    }

    private String getPath(HttpServletRequest request) {
        String path = request.getServletPath();
        if (path.equalsIgnoreCase("/error")) {
            path = "errorUrl:" + Objects.toString(request.getAttribute("javax.servlet.error.request_uri"));
        }
        return path;
    }

}
