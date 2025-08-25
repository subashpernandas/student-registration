package com.tech.subash.design.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TextStyleFactory {
    private  static final Map<String, TextStyle> style = new HashMap<>();
    public static TextStyle getStyle(String font, int size, boolean bold){
        String  key = font + size + bold;
        if(!style.containsKey(key)){
            style.put(key, new TextStyle(font,size,bold));
        }
        return  style.get(key);
    }
}
