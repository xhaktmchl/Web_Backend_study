package com.sparta_spring.sparta_springcore_week01.service;

import com.sparta_spring.sparta_springcore_week01.model.Product;
import com.sparta_spring.sparta_springcore_week01.dto.ProductMypriceRequestDto;
import com.sparta_spring.sparta_springcore_week01.dto.ProductRequestDto;
import com.sparta_spring.sparta_springcore_week01.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private static final int MIN_PRICE = 100;
    // DI의존주입 ProductRepository 재활용
    //생성자
    @Autowired // DI 받는것 표시
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    // 회원 ID 로 등록된 모든 상품 조회
    public List<Product> getProducts(Long userId) {
        return productRepository.findAllByUserId(userId); // 로그인 된 회원 아이디로 관심상품 목록 가져옴
    }
    // 모든 상품 조회 (관리자용)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

//    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
//    public Product createProduct(ProductRequestDto requestDto) {
//        // 요청받은 DTO 로 DB에 저장할 객체 만들기
//        Product product = new Product(requestDto);
//        productRepository.save(product);
//        return product;
//    }

    // 회원 관심상품 생성 및 저장
    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Product createProduct(ProductRequestDto requestDto,Long userid) {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto,userid);
        productRepository.save(product);
        return product;
    }

    // 회원 최저가격 업데이트
    @Transactional
    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );

        // 변경될 관심 가격이 유효한지 확인합니다.
        int myPrice = requestDto.getMyprice();
        if (myPrice < MIN_PRICE) {
            throw new IllegalArgumentException("유효하지 않은 관심 가격입니다. 최소 " + MIN_PRICE + " 원 이상으로 설정해 주세요.");
        }

        product.updateMyPrice(requestDto);
        return product;
    }

}