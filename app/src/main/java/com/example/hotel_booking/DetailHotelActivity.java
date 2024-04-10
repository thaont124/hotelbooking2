package com.example.hotel_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailHotelActivity extends AppCompatActivity {

    private TextView showMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);

        TextView textView = findViewById(R.id.textView5);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailHotelActivity.this, DetialOfServiceActivity.class);
                startActivity(intent);
            }
        });;

        TextView textView1 = findViewById(R.id.textView13);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailHotelActivity.this, CommentActivity.class);
                startActivity(intent);
            }
        });;
//
//        showMap = findViewById(R.id.showMap);
//        showMap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DetailHotelActivity.this, MapsActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}