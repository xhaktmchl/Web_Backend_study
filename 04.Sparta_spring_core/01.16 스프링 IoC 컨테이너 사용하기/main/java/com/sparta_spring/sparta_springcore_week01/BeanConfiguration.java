package com.sparta_spring.sparta_springcore_week01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링 Ioc 컨테이너임을 선언
public class BeanConfiguration {

    @Bean // 스프링 Ioc 컨테이너에 빈 객체로 저장
    public ProductRepository productRepository() {
        String dbId = "sa";
        String dbPassword = "";
        String dbUrl = "jdbc:h2:mem:springcoredb";
        return new ProductRepository(dbId, dbPassword, dbUrl);
    }

    @Bean // 스프링 Ioc 컨테이너에 빈 객체로 저장
    @Autowired // DI를 받는것을 표시
    public ProductService productService(ProductRepository productRepository){
        return new ProductService(productRepository);
    }
}
