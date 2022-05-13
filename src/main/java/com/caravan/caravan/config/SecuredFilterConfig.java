package com.caravan.caravan.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SecuredFilterConfig {

    private final JwtFilter jwtFilter;

    @Bean
    public FilterRegistrationBean filterRegistrationBeanRegion() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(jwtFilter);
        bean.addUrlPatterns("/profile/adm/*");
        return bean;
    }

}
