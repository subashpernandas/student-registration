package com.tech.subash.collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Developer {

    private String name;
    private int age;
    private Dept dept;
    private List<Address> addressList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Dept {
        private String deptName;
        private int totalNoOfStudent;
        private int packages;
        private String gender;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Address {
        private String city;
        private String state;
        private String zip;
    }

    public static void main(String[] args) {

        Dept itDept = new Dept();
        itDept.setDeptName("IT");
        itDept.setTotalNoOfStudent(120);
        itDept.setPackages(16);
        itDept.setGender("Male");

        Dept cseDept = new Dept();
        cseDept.setDeptName("CSE");
        cseDept.setTotalNoOfStudent(120);
        cseDept.setPackages(14);
        cseDept.setGender("Female");

        Address address = new Address();
        address.setCity("Km Kottai");
        address.setState("Tamil nadu");
        address.setZip("623603");

        Address address2 = new Address();
        address2.setCity("Keelkattazhai");
        address2.setState("Tamil nadu");
        address2.setZip("600117");

        Address address3 = new Address();
        address3.setCity("Chennai");
        address3.setState("Tamil nadu");
        address3.setZip("600001");

        Address address4 = new Address();
        address4.setCity("Madurai");
        address4.setState("Tamil nadu");
        address4.setZip("623601");

        Developer developer = new Developer();
        developer.setName("subash");
        developer.setAge(32);
        developer.setDept(itDept);
        developer.setAddressList(List.of(address, address2));

        Developer developer2 = new Developer();
        developer2.setName("ajith");
        developer2.setAge(23);
        developer2.setDept(cseDept);
        developer2.setAddressList(List.of(address3, address4));

        Developer developer3 = new Developer();
        developer3.setName("monish");
        developer3.setAge(32);
        developer3.setDept(itDept);
        developer3.setAddressList(List.of(address2));

        Developer developer4 = new Developer();
        developer4.setName("aryan");
        developer4.setAge(13);
        developer4.setDept(cseDept);
        developer4.setAddressList(List.of(address, address2));

        List<Developer> developerList = List.of(developer, developer2, developer3, developer4);

        Predicate<Developer> zipPredicate = predicateDeveloper -> predicateDeveloper.getAddressList().stream().anyMatch(addr -> addr.getZip().equalsIgnoreCase("600001"));
        Predicate<Address> addressPredicate = addr -> "600001".equalsIgnoreCase(addr.getZip());

        Map<String, List<Address>> developers = developerList.stream()
                .filter(Objects::nonNull)
                .map(dev -> {
                    return new AbstractMap.SimpleEntry<>(dev.getName(), dev.getAddressList().stream().filter(addressPredicate).toList());
                })
                .filter(entry -> !entry.getValue().isEmpty())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(developers);

        Map<String, List<Address>> developers2 = developerList.stream()
                .filter(Objects::nonNull)
                .flatMap(dev -> dev.getAddressList().stream().filter(addressPredicate)
                        .map(adder -> new AbstractMap.SimpleEntry<>(dev.getName(), adder)))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));
        System.out.println(developers2);

        Map<String, List<Address>> developers3 = developerList.stream()
                .filter(Objects::nonNull)
                .filter(zipPredicate)
                .collect(Collectors.toMap(
                        Developer::getName,
                        dev -> dev.getAddressList().stream().filter(addressPredicate).collect(Collectors.toList())
                ));
        System.out.println(developers3);

        // Dept And NoOfMember

        Map<String, Long> eachDeptCount = developerList.stream().collect(Collectors.groupingBy(de -> de.getDept().getDeptName(), Collectors.counting()));
        System.out.println(eachDeptCount);

        // Dept Compare and then NameCompare
        Comparator<Developer> deptComparator = Comparator
                .comparing(Developer::getName)
                .thenComparing(dev -> dev.getDept().getDeptName());
        Map<String, String> mapOfComparing = developerList.stream().sorted(deptComparator).collect(
                Collectors.toMap(Developer::getName, e -> e.getDept().getDeptName(), (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("mapOfComparing " + mapOfComparing);

        Comparator<Developer> reverseComparator = Comparator
                .comparing((Developer dev) -> dev.getDept() != null ? dev.getDept().getDeptName() : "")
                .thenComparing(Developer::getName);
        Map<String, String> reverseMap = developerList.stream().sorted(reverseComparator).collect(
                Collectors.toMap(s -> s.getDept().getDeptName(), Developer::getName, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("reverse Map " + reverseMap);

        // sort keys
        Map<String, Integer> mapOfFruits = new HashMap<>();
        mapOfFruits.put("jackfruit", 200);
        mapOfFruits.put("apple", 150);
        mapOfFruits.put("lemon", 100);
        mapOfFruits.put("guava", 125);
        Map<String, Integer> fruitsMap = mapOfFruits.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(entry -> entry.getKey().startsWith("j") || entry.getValue() > 130)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println(fruitsMap);


        int sum = mapOfFruits.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(entry -> entry.getKey().startsWith("j") || entry.getValue() > 130)
                .mapToInt(Map.Entry::getValue).sum();
        System.out.println(" sum of fruits " + sum);

        IntSummaryStatistics collect = mapOfFruits.entrySet().stream().collect(Collectors.summarizingInt(Map.Entry::getValue));
        System.out.println("int summary statistics " + collect);

        IntSummaryStatistics summaryStatistics = mapOfFruits.values().stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("summaryStatistics " + summaryStatistics);


        String statsSummary = mapOfFruits.values()
                .stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.summarizingInt(Integer::intValue),
                        stats -> String.format("Summary -> Count: %d, Sum: %d, Min: %d, Avg: %.2f, Max: %d",
                                stats.getCount(),
                                stats.getSum(),
                                stats.getMin(),
                                stats.getAverage(),
                                stats.getMax())
                ));

        System.out.println(statsSummary);

        Map.Entry<String, Integer> maxEntry = mapOfFruits.entrySet()
                .stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.maxBy(Map.Entry.comparingByValue()),
                        optional -> optional.orElse(null)  // handle Optional result
                ));

        System.out.println("Most expensive fruit: " + maxEntry);


        List<String> sortedFruitNames = mapOfFruits.keySet()
                .stream()
                .sorted()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));

        System.out.println("sortedFruitNames " + sortedFruitNames);


        Map<String, String> minMaxMap = mapOfFruits.entrySet()
                .stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Map.Entry<String, Integer> min = list.stream()
                                    .min(Map.Entry.comparingByValue())
                                    .orElse(null);
                            Map.Entry<String, Integer> max = list.stream()
                                    .max(Map.Entry.comparingByValue())
                                    .orElse(null);

                            Map<String, String> result = new HashMap<>();
                            if (min != null) {
                                result.put("min", min.getKey() + "=" + min.getValue());
                            }
                            if (max != null) {
                                result.put("max", max.getKey() + "=" + max.getValue());
                            }
                            return result;
                        }
                ));


        PriceRange range = mapOfFruits.entrySet()
                .stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Map.Entry<String, Integer> min = list.stream().min(Map.Entry.comparingByValue()).orElse(null);
                            Map.Entry<String, Integer> max = list.stream().max(Map.Entry.comparingByValue()).orElse(null);
                            return new PriceRange(min.getKey(), min.getValue(), max.getKey(), max.getValue());
                        }
                ));

        System.out.println(" range " + range);

        Map.Entry<String, Integer> maxFruit = mapOfFruits.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        // Find min priced fruit
        Map.Entry<String, Integer> minFruit = mapOfFruits.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElse(null);

        System.out.println("Most expensive fruit: " + maxFruit.getKey() + " = " + maxFruit.getValue());
        System.out.println("Least expensive fruit: " + minFruit.getKey() + " = " + minFruit.getValue());

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 10));
        List<Integer> isAnyMatch = list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), l -> l.stream().filter(n -> n > 2).collect(Collectors.toList())));
        System.out.println("list " + isAnyMatch);
    }
}
