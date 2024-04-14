package com.example.hotel_booking.dto;

public class Customer {
    private String name;
    private String cccd;
    private String email;
    private String phoneNumber;
    private String dateBooking;
    private String dateCheckin;
    private String dateCheckout;
    private String statusPayment;

    public Customer() {
    }

    public Customer(String name, String cccd, String email, String phoneNumber, String dateBooking, String dateCheckin, String dateCheckout, String statusPayment) {
        this.name = name;
        this.cccd = cccd;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateBooking = dateBooking;
        this.dateCheckin = dateCheckin;
        this.dateCheckout = dateCheckout;
        this.statusPayment = statusPayment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(String dateBooking) {
        this.dateBooking = dateBooking;
    }

    public String getDateCheckin() {
        return dateCheckin;
    }

    public void setDateCheckin(String dateCheckin) {
        this.dateCheckin = dateCheckin;
    }

    public String getDateCheckout() {
        return dateCheckout;
    }

    public void setDateCheckout(String dateCheckout) {
        this.dateCheckout = dateCheckout;
    }

    public String getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(String statusPayment) {
        this.statusPayment = statusPayment;
    }
}
