package com.example.hotel_booking.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = TypeRoom.class,
        parentColumns = "idTypeRoom",
        childColumns = "idTypeRoom"))
public class Room {
    @PrimaryKey
    private Long idRoom;

    private String roomNumber;

    private Float pricePerHour;

    private Float pricePerDay;

    @ColumnInfo(name = "idTypeRoom") // Tên cột trong bảng Room
    private TypeRoom typeRoom;

    private Branch branch;

    private int imgId;

    public Room(Long idRoom, String roomNumber, Float pricePerHour, Float pricePerDay, TypeRoom typeRoom, int imgId) {
        this.idRoom = idRoom;
        this.roomNumber = roomNumber;
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.typeRoom = typeRoom;
        this.imgId = imgId;
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
        return typeRoom.getNameType();
    }

    public void setIdTypeRoom(TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }

    public void setTypeRoom(TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
