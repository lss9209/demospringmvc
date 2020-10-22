package me.sangseung.demospringmvc.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/mobile/**")
                .addResourceLocations("classpath:/mobile/")
                .setCachePeriod(20);
    }
}
