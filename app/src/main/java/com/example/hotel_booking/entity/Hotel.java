package com.example.hotel_booking.entity;

public class Hotel {
    private Long idHotel;
    private Integer img;
    private String name,level,place, rate, price;
    public Hotel(){};

    public Hotel(Integer img, String name, String level, String place, String rate, String price) {
        this.img = img;
        this.name = name;
        this.level = level;
        this.place = place;
        this.rate = rate;
        this.price = price;
    }

    public Hotel(Long idHotel, String name, Integer img, Float rate) {
        this.idHotel = idHotel;
        this.img = img;
        this.name = name;
        this.rate = rate.toString();
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }
}
