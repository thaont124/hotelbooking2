package com.example.hotel_booking.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import org.threeten.bp.LocalDateTime;

@Entity(foreignKeys = {
        @ForeignKey(entity = Room.class, parentColumns = "idRoom", childColumns = "roomId"),
        @ForeignKey(entity = User.class, parentColumns = "idUser", childColumns = "idUser")
})

public class Bill {

    @PrimaryKey
    private Long idBill;
    private String billCode;
    @ColumnInfo(name = "idRoom")
    private Room room;
    @ColumnInfo(name = "User")
    private User user;

    private LocalDateTime bookingTime;
    private LocalDateTime checkinTime;

    private LocalDateTime checkoutTime;

    private Float totalPrice;

    private String statusPayment;


    public Bill(Long idBill, String billCode, Room room, User user, LocalDateTime checkinTime, LocalDateTime checkoutTime, Float totalPrice) {
        this.idBill = idBill;
        this.billCode = billCode;
        this.room = room;
        this.user = user;
        this.checkinTime = checkinTime;
        this.checkoutTime = checkoutTime;
        this.totalPrice = totalPrice;
    }

    public Long getIdBill() {
        return idBill;
    }

    public void setIdBill(Long idBill) {
        this.idBill = idBill;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(LocalDateTime checkinTime) {
        this.checkinTime = checkinTime;
    }

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(LocalDateTime checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }
    public Float getVAT() {
        return totalPrice*10/100;
    }

    public Float getGross() {
        return totalPrice + getVAT();
    }


    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(String statusPayment) {
        this.statusPayment = statusPayment;
    }
}
