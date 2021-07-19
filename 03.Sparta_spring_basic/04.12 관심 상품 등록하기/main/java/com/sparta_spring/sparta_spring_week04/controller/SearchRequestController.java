package com.sparta_spring.sparta_spring_week04.controller;

import com.sparta_spring.sparta_spring_week04.models.ItemDto;
import com.sparta_spring.sparta_spring_week04.utils.NaverShopSearch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // JSON으로 응답함을 선언합니다.
@RequiredArgsConstructor // final 로 선언된 클래스를 자동으로 생성합니다.
public class SearchRequestController {// 검색 요청 컨트롤러

    private final NaverShopSearch naverShopSearch; // 검색을 하고 결과를 가져오는 기능을 가진 클래스
    //  NaverShopSearch 를 @Component 등록을 해줘야 @RequiredArgsConstructor 로 자동생성 가능

    @GetMapping("/api/search")
    public List<ItemDto> execSearch(@RequestParam String query){//@RequestParam: url에 ?뒤에오는 변수를 가리킴
        String resultString = naverShopSearch.search(query); // 검색결과 json을 문자열로 반환
        return naverShopSearch.fromJSONtoItems(resultString); // List<ItemDto> 형태로 반환
    }

}
