package com.sparta_spring.sparta_spring_week04.service;

import com.sparta_spring.sparta_spring_week04.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    // 관심상품의 최저가격 업데이트
    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Long update(Long id , ProductMypriceRequestDto requestDto){
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.") // 존재하지 않을 경우 null 처리
        );
        // 상품 찾은다음 매개체로 최저가격 업데이트
        product.update(requestDto);
        return id;
    }

    // 스케쥴러로 관심상품 목록 업데이트 할 때 쓰는 메서드
    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Long updateBySearch(Long id, ItemDto itemDto){
        // 아이디로 상품 불러오고
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        product.updateByItemDto(itemDto);
        return id;
    }
}
