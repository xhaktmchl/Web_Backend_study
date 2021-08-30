package com.sparta_spring.sparta_springcore_week01.service;

import com.sparta_spring.sparta_springcore_week01.dto.SignupRequestDto;
import com.sparta_spring.sparta_springcore_week01.model.User;
import com.sparta_spring.sparta_springcore_week01.model.UserRole;
import com.sparta_spring.sparta_springcore_week01.repository.UserRepository;
import com.sparta_spring.sparta_springcore_week01.security.UserDetailsImpl;
import com.sparta_spring.sparta_springcore_week01.security.kakao.KakaoOAuth2;
import com.sparta_spring.sparta_springcore_week01.security.kakao.KakaoUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC"; // 관리자 확인 토큰
    private final PasswordEncoder passwordEncoder; // 스프링 시큐리티 인코딩 캑체
    private final KakaoOAuth2 kakaoOAuth2;
    //private final AuthenticationManager authenticationManager;

    // 회원 리파지토리 DI
//    @Autowired
//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, KakaoOAuth2 kakaoOAuth2, AuthenticationManager authenticationManager) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.kakaoOAuth2 = kakaoOAuth2;
//        this.authenticationManager = authenticationManager; // 스프링 시큐리티 내장 객체
//    }
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, KakaoOAuth2 kakaoOAuth2, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.kakaoOAuth2 = kakaoOAuth2;
    }

    // 회원가입 기능
    @Transactional
    public User registerUser(SignupRequestDto requestDto){
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
        return userRepository.save(user);

    }

    // 카카오 로그인
    public void kakaoLogin(String authorizedCode) {
        // 카카오 OAuth2 를 통해 카카오 사용자 정보 조회
        KakaoUserInfo userInfo = kakaoOAuth2.getUserInfo(authorizedCode);
        Long kakaoId = userInfo.getId();
        String nickname = userInfo.getNickname();
        String email = userInfo.getEmail();

        // DB 에 중복된 Kakao Id 가 있는지 확인
        User kakaoUser = userRepository.findByKakaoId(kakaoId)
                .orElse(null);

        if (kakaoUser == null) {
            // 카카오 이메일과 동일한 이메일을 가진 회원이 있는지 확인
            User sameEmailUser = userRepository.findByEmail(email).orElse(null);
            if (sameEmailUser != null) {
                kakaoUser = sameEmailUser;
                // 카카오 이메일과 동일한 이메일 회원이 있는 경우
                // 카카오 Id 를 회원정보에 저장
                kakaoUser.setKakaoId(kakaoId);
                userRepository.save(kakaoUser);

            } else {
                // 카카오 정보로 회원가입
                // username = 카카오 nickname
                String username = nickname;
                // password = 카카오 Id + ADMIN TOKEN
                String password = kakaoId + ADMIN_TOKEN;
                // 패스워드 인코딩
                String encodedPassword = passwordEncoder.encode(password);
                // ROLE = 사용자
                UserRole role = UserRole.USER;

                kakaoUser = new User(username, encodedPassword, email, role, kakaoId);
                userRepository.save(kakaoUser);
            }
        }

        // 강제 로그인 처리
        UserDetailsImpl userDetails = new UserDetailsImpl(kakaoUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
