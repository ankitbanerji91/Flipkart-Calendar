package com.flipkart.calendar.entities;

import java.util.Date;

public class TimeRange {
    private Date startTime;
    private Date endTime;

    public TimeRange(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isWithin(TimeRange timeRange) {
        return (timeRange.startTime.before(this.startTime) || timeRange.startTime.equals(this.startTime))
                &&
                (timeRange.endTime.after(this.endTime) || timeRange.endTime.equals(this.endTime));
    }

    @Override
    public String toString() {
        return "TimeRange{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
