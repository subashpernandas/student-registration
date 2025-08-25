package com.tech.subash.arrays;

import org.apache.tomcat.util.net.jsse.JSSEUtil;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        System.out.println(map.put("a", "an")); // null
        System.out.println(map.put("a", "an")); // an
    }
}
