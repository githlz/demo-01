package com.example.demo01;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author hanluozhen
 * @version 1.0.0
 * @ProjectName demo-01
 * @ClassName SpringMVCConfig.java
 * @Description TODO
 * @createTime 2021年09月28日 11:19:00
 */
@Configuration
public class SpringMVCConfig extends WebMvcConfigurationSupport {

    /**
     * 添加自定义的Converters和Formatters.
     */
    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToDateConverter());
    }
}