package com.flipkart.calendar.entities;

import java.util.Objects;

public class Organizer {
    public enum Hierarchy {
        CEO(0),
        COO(1),
        DIRECTOR(2),
        MANAGER(3);

        int priority;

        Hierarchy(int priority) {
            this.priority = priority;
        }
    };

    String name;
    Hierarchy hierarchy;

    public Organizer(String name, Hierarchy hierarchy) {
        this.name = name;
        this.hierarchy = hierarchy;
    }

    public int compareHierarchy(Organizer organizer) {
        if (this.hierarchy.priority > organizer.hierarchy.priority) {
            return 1;
        }

        if (this.hierarchy.priority < organizer.hierarchy.priority) {
            return -1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organizer organizer = (Organizer) o;
        return Objects.equals(name, organizer.name) &&
                hierarchy == organizer.hierarchy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hierarchy);
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "name='" + name + '\'' +
                ", hierarchy=" + hierarchy +
                '}';
    }
}
