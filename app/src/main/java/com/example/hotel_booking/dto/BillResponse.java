package com.example.hotel_booking.dto;

import java.util.List;

public class BillResponse {
    private String billCode;
    private double totalPrice;
    private double discount;
    private double vat;
    private double gross;
    private List<RoomResponse> room;
    private Customer customer;
}
