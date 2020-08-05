package com.flipkart.calendar.impl;

import com.flipkart.calendar.entities.Meeting;
import com.flipkart.calendar.entities.TimeRange;
import com.flipkart.calendar.iface.Calendar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NormalCalendar implements Calendar {
    private final Collection<Meeting> meetings;
    public NormalCalendar(Collection<Meeting> meetings) {
        this.meetings = meetings;
    }

    @Override
    public Collection<Meeting> getMeetings(TimeRange period) {
        List<Meeting> meetingsInTimeRange = new ArrayList<>();
        for (Meeting meeting : meetings) {
            if (meeting.withinTimeRange(period)) {
                meetingsInTimeRange.add(meeting);
            }
        }
        return meetingsInTimeRange;
    }
}
