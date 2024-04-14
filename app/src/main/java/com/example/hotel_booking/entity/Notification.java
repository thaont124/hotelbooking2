package com.example.hotel_booking.entity;

import org.threeten.bp.LocalDateTime;

import java.io.Serializable;

public class Notification implements Serializable {
    private int idNotification;
    private int imgId;
    private String content;

    private int type;

    private String dateNotice;

    public Notification(int idNotification, int imgId, String content, int type, String date) {
        this.idNotification = idNotification;
        this.imgId = imgId;
        this.content = content;
        this.type = type;
        this.dateNotice = date;
    }

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public String getDateNotice() {
        return dateNotice;
    }

    public void setDateNotice(String dateNotice) {
        this.dateNotice = dateNotice;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDate() {
        return dateNotice;
    }

    public void setDate(String date) {
        this.dateNotice = date;
    }
}
