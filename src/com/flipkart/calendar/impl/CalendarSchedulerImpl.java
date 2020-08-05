package com.flipkart.calendar.impl;

import com.flipkart.calendar.entities.Meeting;
import com.flipkart.calendar.entities.Organizer;
import com.flipkart.calendar.entities.TimeRange;
import com.flipkart.calendar.iface.Calendar;
import com.flipkart.calendar.iface.CalendarScheduler;

import java.util.*;

public class CalendarSchedulerImpl implements CalendarScheduler {
    private final Comparator<Meeting> meetingComparator;

    public CalendarSchedulerImpl(Comparator<Meeting> meetingComparator) {
        this.meetingComparator = meetingComparator;
    }

    @Override
    public Collection<Meeting> scheduleMeetings(Calendar calendar, TimeRange timeRange, Organizer organizer) {
        final Collection<Meeting> meetings  = calendar.getMeetings(timeRange);
        final Collection<Meeting> sortedMeetingsWithPriority = getSortedMeetings(meetings);
        final List<Meeting> meetingsScheduled = new ArrayList<>();
        for (Meeting meeting : sortedMeetingsWithPriority) {
            if (canScheduleMeeting(meeting, meetingsScheduled)) {
                meetingsScheduled.add(meeting);
            }
        }
        return meetingsScheduled;
    }

    private boolean canScheduleMeeting(Meeting meeting, List<Meeting> meetingsScheduled) {
        for (Meeting alreadyScheduledMeeting : meetingsScheduled) {
            if (alreadyScheduledMeeting.isConflicting(meeting)) {
                return false;
            }
        }
        return true;
    }

    private Collection<Meeting> getSortedMeetings(Collection<Meeting> meetings) {
        List<Meeting> meetingsList = new ArrayList<>();
        for (Meeting meeting : meetings) {
            meetingsList.add(meeting);
        }
        Collections.sort(meetingsList, meetingComparator);
        return meetingsList;
    }
}
