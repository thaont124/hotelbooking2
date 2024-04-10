package com.example.hotel_booking.entity;

import java.util.Date;

public class Comment {
    private long idComment;
    private int image, avatar;
    private String username, context, rate;
    private Date date;
    public Comment(){};

    public Comment(long idComment, int image, int avatar, String username, String context, String rate, Date date) {
        this.idComment = idComment;
        this.image = image;
        this.avatar = avatar;
        this.username = username;
        this.context = context;
        this.rate = rate;
        this.date = date;
    }

    public long getIdComment() {
        return idComment;
    }

    public void setIdComment(long idComment) {
        this.idComment = idComment;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
