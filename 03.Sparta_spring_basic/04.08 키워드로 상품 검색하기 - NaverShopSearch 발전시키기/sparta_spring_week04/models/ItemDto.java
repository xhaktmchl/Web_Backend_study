package com.sparta_spring.sparta_spring_week04.models;

import lombok.Getter;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.json.JSONObject;


@Getter
public class ItemDto { // 네이버 검색 결과 상품의 정보의 매개체
    private String title;
    private String image;
    private int lprice;
    private String link;

    // 다른 DTO는 같은 Product 객체를 전달한 거여서 @RequiredArgConstruct 가자동 완성했지만
    // ItemDto JSONOject 를 받는 거여서 생성자 따로 생성
    public ItemDto(JSONObject itemJson){
        this.title = itemJson.getString("title");
        this.image = itemJson.getString("image");
        this.lprice = itemJson.getInt("lprice");
        this.link = itemJson.getString("link");
    }
}
