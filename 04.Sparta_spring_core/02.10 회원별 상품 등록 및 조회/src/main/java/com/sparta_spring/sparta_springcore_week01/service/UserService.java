package com.sparta_spring.sparta_springcore_week01.service;

import com.sparta_spring.sparta_springcore_week01.dto.SignupRequestDto;
import com.sparta_spring.sparta_springcore_week01.model.User;
import com.sparta_spring.sparta_springcore_week01.model.UserRole;
import com.sparta_spring.sparta_springcore_week01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC"; // 관리자 확인 토큰
    private final PasswordEncoder passwordEncoder; // 스프링 시큐리티 인코딩 캑체
    // 회원 리파지토리 DI
    @Autowired
    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입 기능
    @Transactional
    public void registerUser(SignupRequestDto requestDto){
       String username = requestDto.getUsername();
       String email = requestDto.getEmail();
        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUsername(username); // id중복조회,
        //Optional<> 객체는 null 까지 커버해서 조회하거나 찾을 시 사용.
        if(found.isPresent()){
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }

        // 패스워드 인코딩= 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());

        // 사용자 ROLE 확인
        UserRole role = UserRole.USER; // 일반 사용자
        if(requestDto.isAdmin()){ // 관리자용으로 요청했으면
            if(!requestDto.getAdminToken().equals(ADMIN_TOKEN)){ // 관리자 토큰 비교
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRole.ADMIN; // 관리자면 관리자용 등록
        }

        // 회원 리파지토리에 저장
        User user = new User(username,password,email,role);
        userRepository.save(user);
        return;
    }

}
