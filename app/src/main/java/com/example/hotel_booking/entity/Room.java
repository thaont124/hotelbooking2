package com.example.hotel_booking.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

public class Room {
    private Long idRoom;

    private String roomNumber;

    private Float pricePerHour;

    private Float pricePerDay;

    private String typeRoom;

    private String hotelName;

    public Room(){}
    public Room(Long idRoom, String roomNumber, Float pricePerHour, Float pricePerDay, String typeRoom) {
        this.idRoom = idRoom;
        this.roomNumber = roomNumber;
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.typeRoom = typeRoom;
    }

    public Long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Float getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelName() {
        return hotelName;
    }
}
