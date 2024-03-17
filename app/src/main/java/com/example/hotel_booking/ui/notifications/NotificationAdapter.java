package com.example.hotel_booking.ui.notifications;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_booking.R;
import com.example.hotel_booking.model.Notification;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {
    private List<Notification> mListNotification;

    public NotificationAdapter(List<Notification> mListNotification) {
        this.mListNotification = mListNotification;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);

        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        Notification notification = mListNotification.get(position);
        if (notification == null){
            return;
        }
        holder.imgNotification.setImageResource(notification.getImgId());
        holder.txtContent.setText(notification.getContent());
        holder.txtDate.setText(String.format(notification.getDate()));
    }

    @Override
    public int getItemCount() {
        if (mListNotification != null){
            return mListNotification.size();
        }
        return 0;
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgNotification;
        private TextView txtContent;
        private TextView txtDate;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imgNotification = itemView.findViewById(R.id.img_read);
            this.txtContent = itemView.findViewById(R.id.name_notification);
            this.txtDate = itemView.findViewById(R.id.date_notification);
        }
    }
}
