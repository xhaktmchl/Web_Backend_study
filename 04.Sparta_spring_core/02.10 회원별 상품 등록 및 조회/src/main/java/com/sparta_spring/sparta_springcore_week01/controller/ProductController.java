package com.sparta_spring.sparta_springcore_week01.controller;

import com.sparta_spring.sparta_springcore_week01.model.Product;
import com.sparta_spring.sparta_springcore_week01.dto.ProductMypriceRequestDto;
import com.sparta_spring.sparta_springcore_week01.dto.ProductRequestDto;
import com.sparta_spring.sparta_springcore_week01.security.UserDetailsImpl;
import com.sparta_spring.sparta_springcore_week01.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductController {
    // 멤버 변수 선언
    private final ProductService productService;
    // 의존주입으로 ProductService 재활용
    // 생성자: ProductController() 가 생성될 때 호출됨
    @Autowired // DI 받는 것잇을 표시
    public ProductController(ProductService productService){
        this.productService = productService;
    }


//    // 등록된 전체 상품 목록 조회
//    @GetMapping("/api/products")
//    public List<Product> getProducts() throws SQLException {
//        List<Product> products = productService.getProducts();
//        // 응답 보내기
//        return products;
//    }
    // 등록된 전체 상품 목록 조회
    // 로그인한 회원이 등록한 상품들 조회
    @GetMapping("/api/products")
    public List<Product> getProducts(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long userId = userDetails.getUser().getId();
        return productService.getProducts(userId);
    }

    // (관리자용) 등록된 모든 상품 목록 조회
    @GetMapping("/api/admin/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // 신규 상품 등록
//    @PostMapping("/api/products")
//    public Product createProduct(@RequestBody ProductRequestDto requestDto) throws SQLException {
//        Product product = productService.createProduct(requestDto);
//        // 응답 보내기
//        return product;
//    }
    // 신규 상품 등록
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 로그인 되어 있는 ID
        Long userId = userDetails.getUser().getId();

        Product product = productService.createProduct(requestDto, userId);
        // 응답 보내기
        return product;
    }


    // 설정 가격 변경
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) throws SQLException {
        Product product = productService.updateProduct(id, requestDto);
        return product.getId();
    }


}