package com.tech.subash.java8.functional;

import java.util.*;

public interface PlayerFunctionalInterface {

     Map<String,Integer> getMap = Map.of("cricket", 100, "football", 150);

    /*static Map<String, Integer> getMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("cricket", 100);
        map.put("football", 99);
        return map;
    }*/
    String playerDetails(String playerName, String game);

    default int playerFee(String game) {
        return getMap.get(game);
    }

    static int titleWin(String game){
        return getMap.get(game);
    }
}
