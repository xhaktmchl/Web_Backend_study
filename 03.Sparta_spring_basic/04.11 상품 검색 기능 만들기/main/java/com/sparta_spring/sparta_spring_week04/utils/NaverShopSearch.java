package com.sparta_spring.sparta_spring_week04.utils;

import com.sparta_spring.sparta_spring_week04.models.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component // 이제부터, @RequiredArgsConstructor 와 함께 사용할 경우 스프링이 자동으로 생성합니다.
//  NaverShopSearch 를 @Component 등록을 해줘야 @RequiredArgsConstructor 로 자동생성 가능
public class NaverShopSearch {
    // 네이버 검색 api  , ARC에서 가져온 GET 코드
    public String search(String query) { // 검색어 받아서
        // ARC에서 가져온 네이버 api GET 코드
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "Y2PMCJtP_nbIC3jX1Xv6"); // 네이버에서 발급받은 id
        headers.add("X-Naver-Client-Secret", "qRV0POeqMQ"); // 네이버에서 발급받은 secret
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        // 밑의 코드에서 호출 url 변수에 검색어나 여러 변수 설정 가능
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query="+query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    // 검색된 상품들 JSON객체에서 -> ItemDto리스트로 반환 메서드
    public List<ItemDto> fromJSONtoItems(String result) {
        JSONObject rjson = new JSONObject(result); // 네이버 검색 결과 문자열 -> json객체로 변환
        System.out.println(rjson); // 검색된json 객체 확인
        JSONArray items = rjson.getJSONArray("items"); // 검색된 json객체에서 키값이 items인 json 리스트 추출

        // 받아온 items 를 List에다가 저장
        List<ItemDto> itemDtoList = new ArrayList<>();
        for (int i = 0; i < items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i); // i번째 인덱스의 json객체를 가져와라
            //System.out.println(itemJson);
            // 추출된 하나의 객체에서 상품이름,사진,최저가,링크 출력확인
//            String title = itemJson.getString("title");
//            String image = itemJson.getString("image");
//            int lprice = itemJson.getInt("lprice");
//            String link = itemJson.getString("link");
//            System.out.println(lprice);//

            // ItemDto 객체로 변환해 ArrayList 에 저장장
            ItemDto itemDto = new ItemDto(itemJson);
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }
    // 메인함수 실행해서 응답확인
//    public static void main(String[] args) {
//        NaverShopSearch naverShopSearch = new NaverShopSearch();
//        String result = naverShopSearch.search("아이맥");
//            JSONObject rjson = new JSONObject(result); // 네이버 검색 결과 문자열 -> json객체로 변환
//            System.out.println(rjson); // 검색된json 객체 확인
//            JSONArray items = rjson.getJSONArray("items"); // 검색된 json객체에서 키값이 items인 json 리스트 추출
//            // 받아온 items 를 List에다가 저장
//            List<ItemDto> itemDtoList = new ArrayList<>();
//
//            for(int i=0;i<items.length();i++){
//                JSONObject itemJson = items.getJSONObject(i); // i번째 인덱스의 json객체를 가져와라
//                //System.out.println(itemJson);
//                // 추출된 하나의 객체에서 상품이름,사진,최저가,링크 출력확인
////            String title = itemJson.getString("title");
////            String image = itemJson.getString("image");
////            int lprice = itemJson.getInt("lprice");
////            String link = itemJson.getString("link");
////            System.out.println(lprice);//
//
//                // ItemDto 객체로 변환해 ArrayList 에 저장장
//                ItemDto itemDto = new ItemDto(itemJson);
//                itemDtoList.add(itemDto);
//        }
//
//    }
    }