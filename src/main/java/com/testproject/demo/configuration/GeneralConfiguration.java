package com.testproject.demo.configuration;

import com.testproject.demo.bean.GeneralProperties;
import com.testproject.demo.bean.GeneralPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {
    @Value("${mockapi.uri}")
    private String uri;

    @Bean
    public GeneralProperties function () {
        return new GeneralPropertiesImplement(uri);
    }
}
