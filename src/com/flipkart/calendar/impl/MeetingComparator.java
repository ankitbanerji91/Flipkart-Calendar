package com.flipkart.calendar.impl;

import com.flipkart.calendar.entities.Meeting;
import com.flipkart.calendar.entities.Organizer;

import java.util.Comparator;

public class MeetingComparator implements Comparator<Meeting> {
    private final Organizer o;
    public MeetingComparator(Organizer o) {
        this.o = o;
    }
    @Override
    public int compare(Meeting m1, Meeting m2) {
        if (m1.organizer.equals(o)) {
            return -1;
        }

        if (m2.organizer.equals(o)) {
            return 1;
        }

        // Same hirerachy
        if (m1.organizer.compareHierarchy(m2.organizer) == 0) {
            if (m1.numberOfParticipants > m2.numberOfParticipants) {
                return -1;
            } else {
                return 1;
            }
        }

        return m1.organizer.compareHierarchy(m2.organizer);
    }
}
