package com.example.hotel_booking;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.hotel_booking.adapter.DetailAdapter;
import com.example.hotel_booking.entity.Bill;
import com.example.hotel_booking.entity.Notification;
import com.example.hotel_booking.entity.Room;
import com.example.hotel_booking.entity.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailNotificationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DetailAdapter detailAdapter;
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notification);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        Notification notification = (Notification) bundle.get("notification");


        recyclerView = findViewById(R.id.detaiNotificationRclView);
        detailAdapter = new DetailAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        getBill(new BillCallback<Bill>() {
            @Override
            public void onSuccess(Bill bill) {
                detailAdapter.setBillData(bill);
                recyclerView.setAdapter(detailAdapter);
            }
        }, String.valueOf(notification.getIdNotification()));


    }

    private void getBill(final BillCallback<Bill> callback, String idNotification) {

        mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://protective-toes-production.up.railway.app/apiv1/notification/detail/" + idNotification, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String billCode = response.getString("billCode");
                            Float totalPrice = (float) response.getDouble("totalPrice");
                            int discount = response.getInt("discount");
                            int vat = response.getInt("vat");
                            int gross = response.getInt("gross");


                            JSONArray roomsJson = response.getJSONArray("room");
                            JSONObject roomJson = (JSONObject) roomsJson.get(0);

                            JSONObject userJson = response.getJSONObject("customer");
                            User user = new User();
                            user.setFullName(userJson.getString("name"));
                            user.setCccd(userJson.getString("cccd"));
                            user.setEmail(userJson.getString("email"));

                            Room room = new Room();
                            room.setRoomNumber(roomJson.getString("numberRoom"));
                            room.setPricePerDay((float) roomJson.getDouble("pricePerDay"));
                            room.setTypeRoom(roomJson.getString("typeRoom"));
                            room.setHotelName(roomJson.getString("hotelName"));

                            user.setPhoneNumber(userJson.getString("phoneNumber"));
                            String dateBooking = userJson.getString("dateBooking");
                            String dateCheckin = userJson.getString("dateCheckin");
                            String dateCheckout = userJson.getString("dateCheckout");
                            String status = userJson.getString("statusPayment");
                            Bill bill = new Bill(1L, billCode, room, user, dateBooking, dateCheckin, dateCheckout, totalPrice);
                            callback.onSuccess(bill);

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

            }
        });
        mRequestQueue.add(jsonObjectRequest);
    }

    interface BillCallback<T> {

        void onSuccess(T a);
    }
}