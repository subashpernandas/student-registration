package com.tech.subash.immutable.breaking;

import java.util.Date;

// Mutable Fields Inside Immutable Class
final class Event {
    private final Date date;

    public Event(Date date) {
        this.date = new Date(date.getTime()); // ❌ No defensive copy
    }

    public Date getDate() {
        return new Date(date.getTime()); // ❌ Returns the same reference
    }
}

public class BreakImmutable2 {
    public static void main(String[] args) {
        Date d = new Date();
        Event e = new Event(d);

        System.out.println("Before: " + e.getDate());

        // Mutate through returned reference
        e.getDate().setTime(0);

        System.out.println("After: " + e.getDate());
    }
}
