package com.flipkart.calendar.iface;

import com.flipkart.calendar.entities.Meeting;
import com.flipkart.calendar.entities.TimeRange;

import java.util.Collection;

public interface Calendar {
    public Collection<Meeting> getMeetings(TimeRange timeRange);
}
