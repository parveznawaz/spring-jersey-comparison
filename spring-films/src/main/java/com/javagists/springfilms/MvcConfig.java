package com.javagists.springfilms;

import com.javagists.springfilms.interceptor.FilmRequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    private final FilmRequestInterceptor filmRequestInterceptor;

    public MvcConfig(FilmRequestInterceptor filmRequestInterceptor) {
        this.filmRequestInterceptor = filmRequestInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(filmRequestInterceptor).addPathPatterns("/**");
    }
}
