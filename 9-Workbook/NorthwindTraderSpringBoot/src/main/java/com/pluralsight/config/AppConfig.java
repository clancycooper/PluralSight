package com.pluralsight.config;

import com.pluralsight.dao.ProductDAOImp;
import com.pluralsight.dao.ProductDAOInt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProductDAOInt productDAOInt(){
        return new ProductDAOImp();
    }
}
