package com.unistmo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebService extends SpringBootServletInitializer {
    /**
     * Clase main.
     * @param args
     */
    public static void main(final String[] args) {
        SpringApplication.run(WebService.class, args);
    }

    /**
     * Configura el proyecto para ser deployado en un application server.
     * @param builder a builder for the application context
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
        return builder.sources(WebService.class);
    }
}
