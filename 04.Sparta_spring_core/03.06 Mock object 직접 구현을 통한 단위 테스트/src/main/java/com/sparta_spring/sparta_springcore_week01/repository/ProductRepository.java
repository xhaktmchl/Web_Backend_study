package com.sparta_spring.sparta_springcore_week01.repository;

import com.sparta_spring.sparta_springcore_week01.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByUserId(Long userId);

}
