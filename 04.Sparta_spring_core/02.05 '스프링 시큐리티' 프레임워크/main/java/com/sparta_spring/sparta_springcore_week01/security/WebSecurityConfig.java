package com.sparta_spring.sparta_springcore_week01.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();

        http.authorizeRequests()
                .anyRequest().authenticated() // 어떤 요청도 모두 인증
                .and()
                .formLogin() // 로그인 페이지는
                .defaultSuccessUrl("/")
                .permitAll() // 모두 허용
                .and() // 그리고
                .logout()//로그아웃도
                .permitAll(); //모두허용
    }
}
