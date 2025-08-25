package com.tech.subash.java8.functional;

import com.tech.subash.java8.functional.custom.TriPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/*
   filter();
   removeIf(Predicate);
   anyMatch();
   allMatch();
   noneMatch();
   Optional.filter();
 */
public class PredicateFunctionAccess {
    static  List<String> names = List.of("Sam", "Subash", "Steve", "Joe");

    public static void main(String[] args) {
        PredicateFunction predicateFunction = (marks) -> marks > 35;
        boolean isPass = predicateFunction.isStudentPass(50);
        System.out.println(isPass);

        Predicate<String> predicateStr =  (name) -> name.startsWith("s");
        boolean predicateResult = predicateStr.test("ps.subash");
        System.out.println(predicateResult);

        BiPredicate<String, Integer> biPredicate = (name, marks) -> name.startsWith("s") && marks > 35;
        boolean biPredicateResult = biPredicate.test("subash", 26);
        System.out.println(biPredicateResult);

        TriPredicate<String, Integer, String> triPredicate = (name, marks, fatherName) -> name.startsWith("s") && marks > 35 && fatherName.startsWith("p");
        boolean triPredicateResult = triPredicate.test("subash",36,"pernandas");
        System.out.println(triPredicateResult);

        Predicate<String> namePredicte = Predicate.isEqual("subash");
        System.out.println(namePredicte.test("subash"));

        Predicate<String> startsWithS = name -> name.startsWith("S");
        Predicate<String> lengthGreaterThan4 = name -> name.length() > 4;
        names.stream()
                .filter(startsWithS.and(lengthGreaterThan4))
                .forEach(System.out::println);


        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println(numbers);

        boolean hasShortName = names.stream().anyMatch(n -> n.length() <= 3);
        System.out.println(hasShortName);

        Optional<String> name = Optional.of("Alice");
        name = name.filter(n -> n.startsWith("A"));
    }
}
