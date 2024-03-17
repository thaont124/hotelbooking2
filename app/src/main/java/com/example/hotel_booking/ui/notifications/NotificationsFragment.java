package com.example.hotel_booking.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_booking.R;
import com.example.hotel_booking.databinding.FragmentHistoryBinding;
import com.example.hotel_booking.model.Notification;

import org.threeten.bp.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private RecyclerView rcvNotification;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        rcvNotification = root.findViewById(R.id.rcv_notification);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        rcvNotification.setLayoutManager(gridLayoutManager);

        NotificationAdapter adapter = new NotificationAdapter(getListNotification());
        rcvNotification.setAdapter(adapter);

        return root;
    }

    private List<Notification> getListNotification() {
        List<Notification> list = new ArrayList<>();

        // Adding Notification objects with specific values
        list.add(new Notification(R.drawable.ic_notread, "Notification Content 1", 1, LocalDateTime.parse("2015-02-20T06:30:00")));
        list.add(new Notification(R.drawable.ic_read, "Notification Content 2", 2, LocalDateTime.parse("2015-02-20T06:30:00")));
        list.add(new Notification(R.drawable.ic_notread, "Notification Content 3", 1, LocalDateTime.parse("2015-02-20T06:30:00")));
        list.add(new Notification(R.drawable.ic_notread, "Notification Content 1", 1, LocalDateTime.parse("2015-02-20T06:30:00")));
        list.add(new Notification(R.drawable.ic_read, "Notification Content 2", 2, LocalDateTime.parse("2015-02-20T06:30:00")));
        list.add(new Notification(R.drawable.ic_notread, "Notification Content 3", 1, LocalDateTime.parse("2015-02-20T06:30:00")));
        list.add(new Notification(R.drawable.ic_notread, "Notification Content 1", 1, LocalDateTime.parse("2015-02-20T06:30:00")));
        list.add(new Notification(R.drawable.ic_read, "Notification Content 2", 2, LocalDateTime.parse("2015-02-20T06:30:00")));
        list.add(new Notification(R.drawable.ic_notread, "Notification Content 3", 1, LocalDateTime.parse("2015-02-20T06:30:00")));
        list.add(new Notification(R.drawable.ic_notread, "Notification Content 1", 1, LocalDateTime.parse("2015-02-20T06:30:00")));
        list.add(new Notification(R.drawable.ic_read, "Notification Content 2", 2, LocalDateTime.parse("2015-02-20T06:30:00")));
        list.add(new Notification(R.drawable.ic_notread, "Notification Content 3", 1, LocalDateTime.parse("2015-02-20T06:30:00")));
        // Add more as needed

        return list;
    }
}