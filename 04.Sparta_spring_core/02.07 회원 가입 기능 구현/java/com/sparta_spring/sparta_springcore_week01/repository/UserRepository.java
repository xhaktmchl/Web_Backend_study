package com.sparta_spring.sparta_springcore_week01.repository;


import com.sparta_spring.sparta_springcore_week01.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username); //  회원이 등록한 아이디로 검색 기능
}
