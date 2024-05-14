package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig {
    // Configures Cross-Origin Resource Sharing (CORS) settings to enable cross-origin requests, making the API accessible to the front-end.
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            /**
             * Defines CORS policies, allowing specific HTTP methods, headers, and origins,
             * and specifying exposed headers for cross-origin requests.
             *
             * @param registry represents the CorsRegistry for configuring CORS rules.
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        /** TODO
                         * Add "POST", "PUT", "DELETE", "OPTIONS" to '.allowedMethods()' after implementing full CRUD capabilities in next update
                         **/
                        .allowedMethods("GET")
                        .allowedHeaders("*")
                        .allowedOrigins("*")
                        .exposedHeaders("*");
            }
        };
    }

}
