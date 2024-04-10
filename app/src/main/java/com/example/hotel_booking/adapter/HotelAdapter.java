package com.example.hotel_booking.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_booking.DetailHotelActivity;
import com.example.hotel_booking.R;
import com.example.hotel_booking.entity.Hotel;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private List<Hotel> mHotels;

    private Context mContext;

    public HotelAdapter(List<Hotel> mHotels, Context mContext) {
        this.mHotels = mHotels;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hotel,parent,false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
        Hotel hotel = mHotels.get(position);

        if (hotel == null){
            return;
        }

        holder.imgView.setImageResource(hotel.getImg());
        holder.name.setText(hotel.getName());
        holder.level.setText(hotel.getLevel());
        holder.place.setText(hotel.getPlace());
        holder.rate.setText(hotel.getRate());
        holder.price.setText(hotel.getPrice());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Xử lý sự kiện chuyển trang ở đây
//                // Ví dụ: chuyển sang màn hình chi tiết của khách sạn
//                // Bạn cần truyền thông tin về khách sạn cụ thể (ví dụ: ID của khách sạn) cho màn hình chi tiết
//                Intent intent = new Intent(mContext, DetailHotelActivity.class);
//                intent.putExtra("hotel_id", hotel.getId());
//                mContext.startActivity(intent);
//            }
//        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mở màn hình mới ở đây
                Intent intent = new Intent(mContext, DetailHotelActivity.class);
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        if(mHotels == null)
            return 0;
        return mHotels.size();
    }

    public class HotelViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgView;
        private TextView name,level, place, rate, price;
        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);


            this.imgView = itemView.findViewById(R.id.img);
            this.name = itemView.findViewById(R.id.name);
            this.level = itemView.findViewById(R.id.level);
            this.place = itemView.findViewById(R.id.place);
            this.rate = itemView.findViewById(R.id.rate);
            this.price = itemView.findViewById(R.id.price);

        }
    }

}
