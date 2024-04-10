package com.example.hotel_booking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.hotel_booking.adapter.HotelAdapter;
import com.example.hotel_booking.entity.Hotel;

import java.util.ArrayList;
import java.util.List;

public class List_hotel extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HotelAdapter hotelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hotel);

        ImageView imageView = findViewById(R.id.filter);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List_hotel.this, FilterActivity.class);
                startActivity(intent);
            }
        });;


        recyclerView = findViewById(R.id.lview);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);
        
        hotelAdapter = new HotelAdapter(getListHotel(), this);
        recyclerView.setAdapter(hotelAdapter);

    }

    private List<Hotel> getListHotel() {
        List<Hotel> hotelList = new ArrayList<>();

        // Thêm các đối tượng Hotel vào danh sách
        hotelList.add(new Hotel(R.drawable.img, "Hotel A", "5-star", "New York", "9.0", "$200"));
        hotelList.add(new Hotel(R.drawable.img, "Hotel B", "4-star", "Paris", "8.5", "$150"));
        hotelList.add(new Hotel(R.drawable.imghotel2, "Hotel C", "3-star", "London", "8.0", "$100"));
        return hotelList;
    }


}