package com.flipkart.calendar.impl;

import com.flipkart.calendar.entities.Meeting;
import com.flipkart.calendar.entities.Organizer;
import com.flipkart.calendar.entities.TimeRange;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        //test_OrganizerSeetingMeetingNoMeeting();
        //test_OrganizerSeetingMeetingOneConflictingMeetingWithBoss();
        test_Given_Input_1();
    }

    public static void test_OrganizerSeetingMeetingNoMeeting() {
        Organizer organizer = getOrganizer("Ankit", Organizer.Hierarchy.MANAGER);
        TimeRange timeRange = getTimeRange(1596536030000l, 1596622277790l);
        NormalCalendar normalCalendar = new NormalCalendar(getMeetingList());
        CalendarSchedulerImpl calendarScheduler = new CalendarSchedulerImpl(new MeetingComparator(organizer));
        Collection<Meeting> meetingsScheduled = calendarScheduler.scheduleMeetings(normalCalendar, timeRange, organizer);
        System.out.println(meetingsScheduled);
    }

    public static void test_OrganizerSeetingMeetingOneConflictingMeetingWithBoss() {
        Organizer organizer_main = getOrganizer("Ankit", Organizer.Hierarchy.MANAGER);
        Organizer organizer_secondary = getOrganizer("Prateek", Organizer.Hierarchy.CEO);

        TimeRange timeRange = getTimeRange(1596536030000l, 1596622277790l);
        Meeting meeting1 = new Meeting(organizer_main, timeRange, 5);
        Meeting meeting2 = new Meeting(organizer_secondary, timeRange, 5);
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(meeting1);
        meetings.add(meeting2);

        NormalCalendar normalCalendar = new NormalCalendar(meetings);
        CalendarSchedulerImpl calendarScheduler = new CalendarSchedulerImpl(new MeetingComparator(organizer_main));
        Collection<Meeting> meetingsScheduled = calendarScheduler.scheduleMeetings(normalCalendar, timeRange, organizer_main);
        System.out.println(meetingsScheduled);
    }

    public static void test_Given_Input_1() {
        Organizer organizer_1 = getOrganizer("NITISH", Organizer.Hierarchy.MANAGER);
        Organizer organizer_2 = getOrganizer("Sushma", Organizer.Hierarchy.MANAGER);
        Organizer organizer_3 = getOrganizer("Iravati", Organizer.Hierarchy.MANAGER);
        Organizer organizer_4 = getOrganizer("John", Organizer.Hierarchy.DIRECTOR);

        Organizer organizer_main = getOrganizer("Harish", Organizer.Hierarchy.MANAGER);

        TimeRange timeRange_1 = getTimeRange(1596516300000l, 1596522600000l);
        Meeting meeting1 = new Meeting(organizer_1, timeRange_1, 7);

        TimeRange timeRange_2 = getTimeRange(1596520800000l, 1596524400000l);
        Meeting meeting2 = new Meeting(organizer_2, timeRange_2, 7);

        TimeRange timeRange_3 = getTimeRange(1596522600000l, 1596544200000l);
        Meeting meeting3 = new Meeting(organizer_3, timeRange_3, 7);

        TimeRange timeRange_4 = getTimeRange(1596546000000l, 1596547800000l);
        Meeting meeting4 = new Meeting(organizer_4, timeRange_4, 4);


        List<Meeting> meetings = new ArrayList<>();
        meetings.add(meeting1);
        meetings.add(meeting2);
        meetings.add(meeting3);
        meetings.add(meeting4);

        TimeRange t = getTimeRange(1596516200000l, 1596547900000l);

        NormalCalendar normalCalendar = new NormalCalendar(meetings);
        CalendarSchedulerImpl calendarScheduler = new CalendarSchedulerImpl(new MeetingComparator(organizer_main));
        Collection<Meeting> meetingsScheduled = calendarScheduler.scheduleMeetings(normalCalendar, t, organizer_main);
        System.out.println(meetingsScheduled);
    }

    private static TimeRange getTimeRange(long startTime, long endTime) {
        // 5 aug
        Date end = new Date();
        end.setTime(endTime);
        // 4 aug
        Date start = new Date();
        start.setTime(startTime);

        TimeRange t = new TimeRange(start, end);
        return t;
    }

    private static Organizer getOrganizer(String name, Organizer.Hierarchy hierarchy) {
        Organizer organizer = new Organizer(name, hierarchy);
        return organizer;
    }


    private static Collection<Meeting> getMeetingList() {
        Meeting meeting = new Meeting(getOrganizer("Ankit", Organizer.Hierarchy.MANAGER), getTimeRange(1596536040000l, 1596622277778l), 5);
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(meeting);
        return meetings;
    }
}
