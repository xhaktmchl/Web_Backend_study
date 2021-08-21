package com.sparta_spring.sparta_springcore_week01.security;

import com.sparta_spring.sparta_springcore_week01.model.User;
import com.sparta_spring.sparta_springcore_week01.model.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

// UserDetailsServiceImpl 에서 빼온 회원정보를 담고 있다.
public class UserDetailsImpl implements UserDetails {//UserDetails 시큐리티 기본 인터페이스

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    // 스프링 시큐리티에 일반, 관리자 정보 넘기기
    private static final String ROLE_PREFIX = "ROLE_"; // 스프링 시큐리티 슈칙: ROLE_ 앞에 붙여줘야 role 로 인식
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        UserRole userRole = user.getRole(); // 회원 객체에서 role 정보 추출

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(ROLE_PREFIX + userRole.toString()); // 권한 객체 생성
        Collection<GrantedAuthority> authorities = new ArrayList<>(); // 권한들을 담는 스프링 시큐리티 배열
        authorities.add(authority); // role 권한정보 추가

        return authorities;
    }
}
