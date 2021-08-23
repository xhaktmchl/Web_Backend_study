package com.sparta_spring.sparta_springcore_week01.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONObject;


@Getter
@NoArgsConstructor
public class ItemDto {

    private String title;
    private String image;
    private String link;
    private int lprice;

    public ItemDto(JSONObject itemJson){
        this.title = itemJson.getString("title");
        this.link = itemJson.getString("link");
        this.image = itemJson.getString("image");
        this.lprice = itemJson.getInt("lprice");
    }
}
