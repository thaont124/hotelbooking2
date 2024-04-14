package com.example.hotel_booking.entity;


public class Setting {
    private int noticeCheckin;

    private int timeBeforeCheckin;

    private int noticePoint;

    public Setting() {
    }

    public Setting(int noticeCheckin, int timeBeforeCheckin, int noticePoint) {
        this.noticeCheckin = noticeCheckin;
        this.timeBeforeCheckin = timeBeforeCheckin;
        this.noticePoint = noticePoint;
    }

    public int getNoticeCheckin() {
        return noticeCheckin;
    }

    public void setNoticeCheckin(int noticeCheckin) {
        this.noticeCheckin = noticeCheckin;
    }

    public int getTimeBeforeCheckin() {
        return timeBeforeCheckin;
    }

    public void setTimeBeforeCheckin(int timeBeforeCheckin) {
        this.timeBeforeCheckin = timeBeforeCheckin;
    }

    public int getNoticePoint() {
        return noticePoint;
    }

    public void setNoticePoint(int noticePoint) {
        this.noticePoint = noticePoint;
    }
}
