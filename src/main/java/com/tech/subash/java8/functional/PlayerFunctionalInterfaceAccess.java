package com.tech.subash.java8.functional;

import com.tech.subash.java8.functional.custom.QuadFunction;
import org.apache.commons.lang3.function.TriFunction;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
   map(Function<T, R>);
   Optional.map(Function<T, R>);
   andThen(), compose();
   Map.computeIfAbsent();
   Collectors.mapping();
 */
public class PlayerFunctionalInterfaceAccess {
    public static void main(String[] args) {

        //PlayerFunctionalInterface playerFunctionalInterfaceAccess = (name, game) -> "player "+ name + " playing "+ game;

        Function<String, String> playerFunctionalInter = PlayerFunctionalInterfaceAccess::function;
        String result= playerFunctionalInter.apply("Subash");
        System.out.println(result);

        BiFunction<String, String, String> playerBiFunctionalInterfaceAccess = PlayerFunctionalInterfaceAccess::biFunction;
        String result1 = playerBiFunctionalInterfaceAccess.apply("Subash", "Cricket");
        System.out.println(result1);

        TriFunction<String, String, String, String> playerTriFunctionalInterfaceAccess = PlayerFunctionalInterfaceAccess::triFunction;
        String result2 = playerTriFunctionalInterfaceAccess.apply("Subash", "Cricket", "120");
        System.out.println(result2);


        QuadFunction<String, String, String, String, String> playerQuadFunctionalInterfaceAccess = PlayerFunctionalInterfaceAccess::quadFunction;
        String result3 = playerQuadFunctionalInterfaceAccess.apply("Subash", "Cricket", "120", "31");
        System.out.println(result3);  // custom interface

        // FOR DEFAULT METHOD
        PlayerFunctionalInterface playerFunctionalInterface = new PlayerFunctionalInterface() {
            @Override
            public String playerDetails(String playerName, String game) {
                return "";
            }
            @Override
            public int playerFee(String game) {
                return PlayerFunctionalInterface.super.playerFee(game);
            }
        };

        System.out.println(playerFunctionalInterface.playerFee("cricket"));

        List<String> names = List.of("Alice", "Bob", "Charlie");
        List<Integer> nameLengths = names.stream().map(String::length).toList();
        System.out.println(nameLengths);

        // Optional.map(Function<T, R>);
        Optional<String> name = Optional.of("Alice");
        Optional<Integer> length = name.map(String::length);
        System.out.println(length);

        // andThen(), compose();
        Function<String, Integer> parse = Integer::parseInt;
        Function<Integer, Integer> square = x -> x * x;
        Function<String, Integer> parseThenSquare = parse.andThen(square);
        System.out.println(parseThenSquare.apply("4"));

        //  Map.computeIfAbsent();
        Map<String, List<String>> map = new HashMap<>();
        map.computeIfAbsent("key", k -> new ArrayList<>()).add("value");
        System.out.println(map);

        Map<String, List<Integer>> grouped = Stream.of("Tom", "Timothy", "Anna")
                .collect(Collectors.groupingBy(
                        names1 -> names1.substring(0, 1),               // classifier function
                        Collectors.mapping(String::length, Collectors.toList())
                ));



        System.out.println(grouped); // e.g., {T=[3, 8], A=[4]}


    }

    public static String function(String name){
        return "player "+ name;
    }

    public static String biFunction(String name, String game){
        return "player "+ name + " playing "+ game;
    }

    public static String triFunction(String name, String game, String noOfGames ){
        return "player "+ name + " playing "+ game + "no of games "+ noOfGames;
    }

    public static String quadFunction(String name, String game, String noOfGames, String noOfTitle ){
        return "player "+ name + " playing "+ game + "no of games "+ noOfGames + " no of title " + noOfTitle;
    }

}
