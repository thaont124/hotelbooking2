package com.example.hotel_booking.dto;

public class RoomResponse {
    private String numberRoom;
    private String typeRoom;
    private String hotelName;
    private double pricePerDay;

    public RoomResponse(String numberRoom, String typeRoom, String hotelName, double pricePerDay) {
        this.numberRoom = numberRoom;
        this.typeRoom = typeRoom;
        this.hotelName = hotelName;
        this.pricePerDay = pricePerDay;
    }

    public RoomResponse() {
    }

    public String getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(String numberRoom) {
        this.numberRoom = numberRoom;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
