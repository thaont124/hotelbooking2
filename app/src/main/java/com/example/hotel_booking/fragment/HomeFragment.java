package com.example.hotel_booking.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_booking.List_hotel;
import com.example.hotel_booking.MainActivity;
import com.example.hotel_booking.R;
import com.example.hotel_booking.adapter.NotificationAdapter;
import com.example.hotel_booking.adapter.ViewRecentlyAdapter;
import com.example.hotel_booking.databinding.FragmentHomeBinding;
import com.example.hotel_booking.entity.Hotel;
import com.example.hotel_booking.entity.Notification;

import org.threeten.bp.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView rcvHotel;
    private ImageView recommendImgView;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = this.getContext();
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recommendImgView = root.findViewById(R.id.recommend);
        recommendImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, List_hotel.class);
                startActivity(intent);
            }
        });

        rcvHotel = root.findViewById(R.id.rcl_recently);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvHotel.setLayoutManager(layoutManager);

        ViewRecentlyAdapter adapter = new ViewRecentlyAdapter(this.getContext(), getListHotel());
        rcvHotel.setAdapter(adapter);

        return root;
    }

    private List<Hotel> getListHotel() {
        List<Hotel> list = new ArrayList<>();

        // Adding Notification objects with specific values
        list.add(new Hotel(1L, "Midas Hotel", R.drawable.img_hotel_ex, 4.5f));
        list.add(new Hotel(1L, "Hotel B", R.drawable.img_hotel_ex, 4.5f));
        list.add(new Hotel(1L, "Hotel C", R.drawable.imghotel2, 4f));
        list.add(new Hotel(1L, "Hotel D", R.drawable.imghotel3, 4.5f));
        list.add(new Hotel(1L, "Hotel F", R.drawable.img, 4.5f));

        return list;
    }
}