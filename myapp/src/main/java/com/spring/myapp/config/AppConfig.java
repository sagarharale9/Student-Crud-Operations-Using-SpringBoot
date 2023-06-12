package com.spring.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.spring.myapp.service.StudentService;
import com.spring.myapp.serviceimpl.StudentServiceImpl;

@Configuration
public class AppConfig {
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    //Bean For NGROK 
//    @Bean
//    public StudentService studentService() {
//        return new StudentServiceImpl_NGROK();  
//    }
    
    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl();  
    }
    
    
}
