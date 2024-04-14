package com.example.hotel_booking.dto;


import java.util.List;


public class DetailHotelResponse {
    private String hotelName;
    private float rate;
    private List<PhotoResponse> photo;
    private AddressResponse address;

    public DetailHotelResponse(String hotelName, float rate, List<PhotoResponse> photo, AddressResponse address) {
        this.hotelName = hotelName;
        this.rate = rate;
        this.photo = photo;
        this.address = address;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public List<PhotoResponse> getPhoto() {
        return photo;
    }

    public void setPhoto(List<PhotoResponse> photo) {
        this.photo = photo;
    }

    public AddressResponse getAddress() {
        return address;
    }

    public void setAddress(AddressResponse address) {
        this.address = address;
    }
}
