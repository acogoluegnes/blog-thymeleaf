package com.zenika;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
            AppConfiguration.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
            ContactConfiguration.class   
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
            "/",
            "/blog-thymeleaf"
        };
    }
}