package com.tech.subash.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workers {
    String name;
    Location location;
    List<Project> projects;

    @Data
    @AllArgsConstructor
    static class Project {
        String name;
        String status; // e.g., "ACTIVE", "ON_HOLD", etc.
    }

    @Data
    @AllArgsConstructor
    static class Location {
        String city;
    }

    public static List<Workers> getDumpOfWorkers() {
        return List.of(
                new Workers("Alice", new Location("Bangalore"), List.of(new Project("Payroll App", "ACTIVE"),
                        new Project("Attendance System", "ON_HOLD"))),
                new Workers("Bob", new Location("Bangalore"), List.of(new Project("Inventory Tool", "ACTIVE"))),
                new Workers("Charlie", new Location("Mumbai"), List.of(new Project("Support System", "ACTIVE"))),
                new Workers("Diana", null, List.of(new Project("Finance App", "ACTIVE"))),
                new Workers("Eve", new Location("Bangalore"), List.of()),
                new Workers("Frank", new Location("Bangalore"),
                        List.of(new Project("Legacy System", "ON_HOLD"),
                                new Project("Migration Tool", "ON_HOLD")))
        );
    }

    public static void main(String[] args) {
        Map<String, Integer> activeProjectMap = getDumpOfWorkers().stream()
                .filter(emp -> emp.getLocation() != null) // filter out null locations
                .filter(emp -> "Bangalore".equalsIgnoreCase(emp.getLocation().getCity()))
                .filter(emp -> emp.getProjects() != null && !emp.getProjects().isEmpty())
                .map(emp -> {
                    long activeCount = emp.getProjects().stream()
                            .filter(project -> "ACTIVE".equalsIgnoreCase(project.getStatus()))
                            .count();
                    return new AbstractMap.SimpleEntry<>(emp.getName(), (int) activeCount);
                })
                .filter(entry -> entry.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(activeProjectMap);

        Map<String, Long> activeProjectMapUsingGroupBy = getDumpOfWorkers().stream()
                .filter(emp -> emp.getLocation() != null)
                .filter(emp -> "Bangalore".equalsIgnoreCase(emp.getLocation().getCity()))
                .filter(emp -> emp.getProjects() != null && !emp.getProjects().isEmpty())
                .collect(Collectors.groupingBy(
                        Workers::getName,
                        Collectors.flatMapping(
                                emp -> emp.getProjects().stream()
                                        .filter(project -> "ACTIVE".equalsIgnoreCase(project.getStatus())),
                                Collectors.counting()
                        )
                )).entrySet().stream().filter((entry) -> entry.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue));

        System.out.println(activeProjectMapUsingGroupBy);

    }
}
