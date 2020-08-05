package com.flipkart.calendar.entities;

public class Meeting {
    public Organizer organizer;
    public TimeRange timeRange;
    public int numberOfParticipants;
    public Meeting(Organizer organizer, TimeRange timeRange, int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
        this.organizer = organizer;
        this.timeRange = timeRange;
    }

    public boolean isConflicting(Meeting meeting) {
        boolean value = this.timeRange.conflicts(meeting.timeRange);
        return this.timeRange.conflicts(meeting.timeRange);
    }

    public boolean withinTimeRange(TimeRange period) {
        return this.timeRange.isWithin(period);
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "organizer=" + organizer +
                ", timeRange=" + timeRange +
                ", numberOfParticipants=" + numberOfParticipants +
                '}';
    }
}
