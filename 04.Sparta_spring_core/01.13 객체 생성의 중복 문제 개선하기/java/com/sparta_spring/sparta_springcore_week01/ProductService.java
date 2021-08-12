package com.sparta_spring.sparta_springcore_week01;

import java.sql.SQLException;
import java.util.List;


public class ProductService {

    private final ProductRepository productRepository;
    // 의존주입 ProductRepository 재활용
    //생성자
    public ProductService(){
       this.productRepository = new ProductRepository();
    }

    public List<Product> getProducts() throws SQLException {
        return productRepository.getProducts();
    }

    public Product createProduct(ProductRequestDto requestDto) throws SQLException {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto);
        productRepository.createProduct(product);
        return product;
    }

    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
        // 최저가 0 미만 예외처리
        if(requestDto.getMyprice() < 0){
            throw new IllegalAccessError("최저가는 0 이상입니다.");
        }

        Product product = productRepository.getProduct(id);
        if (product == null) {
            throw new NullPointerException("해당 아이디가 존재하지 않습니다.");
        }
        int myPrice = requestDto.getMyprice();
        productRepository.updateProductMyPrice(id, myPrice);
        return product;
    }
}