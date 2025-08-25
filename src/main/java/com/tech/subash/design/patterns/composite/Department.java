package com.tech.subash.design.patterns.composite;

import java.util.ArrayList;
import java.util.List;

// Composite
class Department implements Participant {
    private final String name;
    private final List<Participant> members = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.print("\"" + name + "\" -> ");
        for (int i = 0; i < members.size(); i++) {
            members.get(i).showDetails();
        }
        System.out.println();
    }

    public void addMember(Participant p) {  // Custom Methods
        members.add(p);
    }
    public void removeMember(Participant p) {  // Custom Methods
        members.remove(p);
    }
}