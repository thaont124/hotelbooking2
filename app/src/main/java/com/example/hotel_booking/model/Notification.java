package com.example.hotel_booking.model;

public class Notification {
    private int imgId;
    private String content;

    private int type;

    public Notification(int imgId, String content, int type) {
        this.imgId = imgId;
        this.content = content;
        this.type = type;
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
}
