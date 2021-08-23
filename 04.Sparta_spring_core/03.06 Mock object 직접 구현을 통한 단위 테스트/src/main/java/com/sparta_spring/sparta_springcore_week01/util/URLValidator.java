package com.sparta_spring.sparta_springcore_week01.util;

import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


public class URLValidator {
    public static boolean urlValidator(String url)
    {
        try {
            new URL(url).toURI(); // 자바 내장 함수
            return true;
        }
        catch (URISyntaxException exception) {
            return false;
        }
        catch (MalformedURLException exception) {
            return false;
        }
    }
}
