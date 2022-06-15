package com.github.usecasemvc;

import com.github.usecasemvc.infrastructure.adapter.web.LocalDispatcherServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class UsecaseMvcApplication {

    /*
        We need to register our custom override of DispatcherServlet
        instead of original dispatcher.
        Based on this answer: https://stackoverflow.com/a/68536242
     */

    @Bean
    public ServletRegistrationBean localDispatcherRegistration() {
        return new ServletRegistrationBean<>(dispatcherServlet());
    }

    @Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet dispatcherServlet() {
        return new LocalDispatcherServlet();
    }

    public static void main(String[] args) {
        SpringApplication.run(UsecaseMvcApplication.class, args);
    }

}
