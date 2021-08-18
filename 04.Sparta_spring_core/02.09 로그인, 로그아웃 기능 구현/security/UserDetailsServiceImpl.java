package com.sparta_spring.sparta_springcore_week01.security;

import com.sparta_spring.sparta_springcore_week01.model.User;
import com.sparta_spring.sparta_springcore_week01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {//UserDetailsService 는 스프링 시큐리티 기본 인터페이스
    // 회원 db에서 로그인아이디 있는지 검사


    // 회원 리파지토리 DI
    @Autowired
    private UserRepository userRepository;

    // 회원 db에서 로그인아이디 있는지 검사
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 아이디 검색 및 예외처리
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Can't find " + username)
        );
        return new UserDetailsImpl(user);
    }
}
