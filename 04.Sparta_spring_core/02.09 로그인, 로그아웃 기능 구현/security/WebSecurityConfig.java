package com.sparta_spring.sparta_springcore_week01.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // 스프링 Ioc 컨테이너임을 나타냄
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // 회원 패스워드 암호화
    // 스프링 security에서 기본 제공
    // PasswordEncoder 가 인터페이스 , BCryptPasswordEncoder는 암호화 중 1종류
    @Bean
    public PasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();


        http.authorizeRequests()

                .antMatchers("/images/**").permitAll()// image 폴더를 login 없이 허용
                .antMatchers("/css/**").permitAll()// css 폴더를 login 없이 허용
                .antMatchers("/user/**").permitAll() // singup 회원가입 페이지를 login 없이 허용
                .antMatchers("/h2-console/**").permitAll() // h2 db에 관한 것 모두 허용

                // 그 외 모든 요청은 인증과정 필요
                .anyRequest().authenticated() // 어떤 요청도 모두 인증
                .and()
                .formLogin() // 로그인 페이지는
                .loginPage("/user/login")//로그인 페이지 주소
                .failureUrl("/user/login/error")// 로그인 실패시 주소
                .defaultSuccessUrl("/")
                .permitAll() // 모두 허용
                .and() // 그리고
                .logout()//로그아웃도
                .logoutUrl("/user/logout") // 로그아읏 주로
                .permitAll(); //모두허용
    }
}
