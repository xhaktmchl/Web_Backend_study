package com.sparta_spring.sparta_spring_week04.controller;

import com.sparta_spring.sparta_spring_week04.models.Product;
import com.sparta_spring.sparta_spring_week04.models.ProductRepository;
import com.sparta_spring.sparta_spring_week04.models.ProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // json 형식 컨트롤러
@RequiredArgsConstructor // 의존주입 생성자 -> final 변수에 적용
public class ProductRestController {

    private final ProductRepository productRepository;

    // 상품조회한 목록 불러오기
    @GetMapping("/api/products")
    public List<Product> readProducts(){
       return productRepository.findAll();
    }

    // 관심상품 등록하기
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto){ //@RequestBody
        Product product = new Product(requestDto);
        return productRepository.save(product);
    }



}
