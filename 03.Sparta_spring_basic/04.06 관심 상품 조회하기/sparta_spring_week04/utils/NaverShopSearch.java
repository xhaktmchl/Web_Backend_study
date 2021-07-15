package com.sparta_spring.sparta_spring_week04.utils;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class NaverShopSearch {
    public String search() {
        // ARC에서 가져온 네이버 api GET 코드
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "Y2PMCJtP_nbIC3jX1Xv6"); // 네이버에서 발급받은 id
        headers.add("X-Naver-Client-Secret", "qRV0POeqMQ"); // 네이버에서 발급받은 secret
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        // 밑의 코드에서 호출 url 변수에 검색어나 여러 변수 설정 가능
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=iphone", HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    // 실행해서 응답확인
    public static void main(String[] args) {
        NaverShopSearch naverShopSearch = new NaverShopSearch();
        naverShopSearch.search();
    }
}
