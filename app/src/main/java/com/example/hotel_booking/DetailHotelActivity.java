package com.example.hotel_booking;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hotel_booking.dto.DetailHotelResponse;
import com.example.hotel_booking.entity.Notification;
import com.example.hotel_booking.entity.Setting;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailHotelActivity extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private ShapeableImageView imgHotel;
    private TextView nameHotel;
    private RatingBar ratingRecently;
    private TextView location;
    private TextView showMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);

        getDetailHotel(new VolleyCallback1() {
            @Override
            public void onSucess(String name, String img, Float rating, String locationString, float latitude, float longitude) {
                nameHotel = findViewById(R.id.nameHotel);
                nameHotel.setText(name);

                imgHotel = findViewById(R.id.imgHotel);
                Picasso.get().load(img).into(imgHotel);

                ratingRecently = findViewById(R.id.ratingRecently);
                ratingRecently.setRating(rating);

                location = findViewById(R.id.location);
                location.setText(locationString);

                showMap = findViewById(R.id.showMap);
                showMap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DetailHotelActivity.this, MapsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("latitude", latitude);
                        bundle.putSerializable("longitude", longitude);
                        bundle.putSerializable("hotelName", name);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
            }
        });
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



    }
    private void getDetailHotel(final VolleyCallback1 callback1){
        mRequestQueue = Volley.newRequestQueue(this); //RequestQueue

        // String Request initialized
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, "https://protective-toes-production.up.railway.app/apiv1/hotel/detail/1",null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    String name = response.getString("hotelName");

                    JSONArray photoArray = response.getJSONArray("photo");
                    JSONObject firstPhoto = photoArray.getJSONObject(0); // Lấy phần tử đầu tiên từ mảng photo
                    String img = firstPhoto.getString("uri");

                    Float rating = (float) response.getDouble("rate");

                    JSONObject objectAddress = response.getJSONObject("address");
                    String locationString = objectAddress.getString("address");
                    float latitude = (float) objectAddress.getDouble("latitude");
                    float longitude = (float) objectAddress.getDouble("longitude");

                    callback1.onSucess(name, img, rating, locationString, latitude, longitude);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();

                        }
                    });
                }catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.networkResponse != null && error.networkResponse.statusCode == 400) {
                    // Handle 400 error here
                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                }

                Log.i(TAG, "Error :" + error.toString());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoaCIsInJvbGUiOlsiYWRtaW4iXSwiaWF0IjoxNzEyNDkwOTUwLCJleHAiOjE3MTI0OTQ1NTB9.Pn6XiKBPfV8bdbFL-SHRR6Mle-W0SKuRDMIOPMbH5t4");
                return headers;
            }
        };

        mRequestQueue.add(jsonObjectRequest);
    }
    public interface VolleyCallback1{

        void onSucess(String name, String img, Float rating, String locationString, float latitude, float longitude);
    }


}