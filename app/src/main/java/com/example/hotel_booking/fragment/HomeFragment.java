package com.example.hotel_booking.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hotel_booking.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Tạo ViewModel để quản lý dữ liệu liên quan đến giao diện
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        // Sử dụng Data Binding để gán layout cho Fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;// Trả về giao diện
    }

    @Override
    public void onDestroyView() { //chuyển qua trang thì nó giải phóng bộ nhớ
        super.onDestroyView();
        binding = null;
    }
}