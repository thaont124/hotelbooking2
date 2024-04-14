package com.example.hotel_booking.fragment;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hotel_booking.R;
import com.example.hotel_booking.adapter.NotificationAdapter;
import com.example.hotel_booking.entity.Notification;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;
import org.threeten.bp.LocalDateTime;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationsFragment extends Fragment {
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private RecyclerView rcvNotification;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        rcvNotification = root.findViewById(R.id.rcv_notification);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        rcvNotification.setLayoutManager(gridLayoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
        rcvNotification.addItemDecoration(itemDecoration);

        getListNotification(new NotificationCallback<List<Notification>>() {
            @Override
            public void onSuccess(List<Notification> notifications) {
                NotificationAdapter adapter = new NotificationAdapter(getContext(), notifications);
                rcvNotification.setAdapter(adapter);
            }
        });
        return root;
    }

    // Thêm một tham số callback vào hàm getListNotification()
    private void getListNotification(final NotificationCallback<List<Notification>> callback) {
        mRequestQueue = Volley.newRequestQueue(getContext());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://protective-toes-production.up.railway.app/apiv1/notification/list/1", null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                try {
                    List<Notification> a = new ArrayList<>();
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);
                        int type = jsonObject.getInt("type");
                        int imgId;
                        if (type == 1){
                            imgId = R.drawable.ic_read;
                        } else if(type == -1){
                            imgId = R.drawable.ic_notread;
                        } else
                            imgId = R.drawable.ic_alarm;
                        String content = jsonObject.getString("content");
                        String date = jsonObject.getString("dateNotice");
                        int id = jsonObject.getInt("idNotification");
                        Notification b = new Notification(id, imgId, content, type, date);
                        a.add(b);
                    }
                    callback.onSuccess(a);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(jsonArrayRequest);
    }

    // Interface callback
    interface NotificationCallback<T>{

        void onSuccess(T a);
    }
}