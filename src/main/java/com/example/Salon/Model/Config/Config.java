package com.example.Salon.Model.Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.File;

@Configuration
public class Config implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/uploads/**")
                .addResourceLocations(new File("C:\\uploads").toURI().toString())
                .addResourceLocations(new File("D:\\uploads").toURI().toString())
                .addResourceLocations(new File("F:\\uploads").toURI().toString())
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
}