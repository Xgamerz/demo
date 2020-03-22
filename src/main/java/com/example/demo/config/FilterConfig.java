package com.example.demo.config;

import com.example.demo.filter.FirstFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<Filter> TestFilter() {
        FilterRegistrationBean<Filter> regFilters = new FilterRegistrationBean<>();
        regFilters.setFilter(new FirstFilter());
        regFilters.addUrlPatterns("/api/*");

        return  regFilters;
    }
}
