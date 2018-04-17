package com.xrom.server.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XRom
 * @date 2018-02-26 10-55
 * interceptor configuration
 */
@Configuration
public class InterceptorConfiguration {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebFilter());
        List<String> filterUrl = new ArrayList<>();
        filterUrl.add("/web/*");
        filterRegistrationBean.setUrlPatterns(filterUrl);
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setName("webFilter");
        return filterRegistrationBean;
    }

    public class WebFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            logger.info("request: " + request.getRequestURI());
            filterChain.doFilter(request, servletResponse);
        }

        @Override
        public void destroy() {

        }
    }

}
