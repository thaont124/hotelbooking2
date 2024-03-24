package com.example.hotel_booking.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_booking.DetailHotelActivity;
import com.example.hotel_booking.DetailNotificationActivity;
import com.example.hotel_booking.R;
import com.example.hotel_booking.entity.Hotel;
import com.example.hotel_booking.entity.Notification;
import com.example.hotel_booking.entity.Room;

import java.util.List;

public class ViewRecentlyAdapter extends RecyclerView.Adapter<ViewRecentlyAdapter.ViewRecentlyHolder>{
    private List<Hotel> mHotel;
    private Context mcontext; //cung cấp thông tin về môi trường ứng dụng

    public ViewRecentlyAdapter(Context context, List<Hotel> hotels) {
        this.mcontext = context;
        this.mHotel = hotels;
    }

    @NonNull
    @Override
    public ViewRecentlyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recently, parent, false);

        return new ViewRecentlyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewRecentlyHolder holder, int position) {
        final Hotel hotel = mHotel.get(position);
        if (hotel == null){
            return;
        }
        holder.imgHotel.setImageResource(hotel.getImgId());
        holder.hotelRecently.setText(hotel.getHotelName());
        holder.ratingBar.setRating(hotel.getRating());
        holder.itemRecently.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoHotelDetail(hotel);
            }
        });
    }

    private void onClickGoHotelDetail(Hotel hotel) {
        Intent intent = new Intent(mcontext, DetailHotelActivity.class); //khai báo để mở activity mới
        mcontext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (mHotel != null){
            return mHotel.size();
        }
        return 0;
    }

    public class ViewRecentlyHolder extends RecyclerView.ViewHolder{
        private LinearLayout itemRecently;
        private ImageView imgHotel;
        private TextView hotelRecently;
        private RatingBar ratingBar;

        public ViewRecentlyHolder(@NonNull View itemView) {
            super(itemView);

            this.itemRecently = itemView.findViewById(R.id.item_recently);
            this.imgHotel = itemView.findViewById(R.id.imgHotelView);
            this.hotelRecently = itemView.findViewById(R.id.hotelRecentlyTxtView);
            this.ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }
}
