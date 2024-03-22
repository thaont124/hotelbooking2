package com.example.hotel_booking.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Branch {
    @PrimaryKey
    private Long idBranch;

    private String branchName;

    private String address;

    private Hotel hotel;

    public Branch(Long idBranch, String branchName, String address, Hotel hotel) {
        this.idBranch = idBranch;
        this.branchName = branchName;
        this.address = address;
        this.hotel = hotel;
    }

    public Long getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Long idBranch) {
        this.idBranch = idBranch;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
