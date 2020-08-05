package com.flipkart.calendar.iface;

import com.flipkart.calendar.entities.Meeting;
import com.flipkart.calendar.entities.Organizer;
import com.flipkart.calendar.entities.TimeRange;

import java.util.Collection;

public interface CalendarScheduler {
    public Collection<Meeting> scheduleMeetings(Calendar calendar, TimeRange timeRange, Organizer organizer);
}
