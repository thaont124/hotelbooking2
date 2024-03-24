package com.example.hotel_booking.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Hotel {
    @PrimaryKey
    private Long idHotel;
    private String hotelName;

    private int imgId;

    private float rating;

    public Hotel() {
    }

    public Hotel(Long idHotel, String hotelName, int imgId, float rating) {
        this.idHotel = idHotel;
        this.hotelName = hotelName;
        this.imgId = imgId;
        this.rating = rating;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
