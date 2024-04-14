package com.example.hotel_booking;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hotel_booking.entity.Notification;
import com.example.hotel_booking.entity.Setting;
import com.example.hotel_booking.fragment.NotificationsFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingNotificationActivity extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private Switch checkinSwitch;
    private EditText editTextNumber;
    private Switch pointSwitch;
    private Button updateSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_notification);

        // Tìm tham chiếu đến EditText
        editTextNumber = findViewById(R.id.editTextNumber);
        // Thiết lập sự kiện chuyển focus
        editTextNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // Kiểm tra xem EditText có focus không
                if (hasFocus) {
                    // Hiển thị bàn phím số
                    editTextNumber.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
                } else {
                    // Ẩn bàn phím khi mất focus
                    editTextNumber.setInputType(android.text.InputType.TYPE_NULL);
                }
            }
        });

        updateSetting = findViewById(R.id.updateSetting);
        updateSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putUpdateSetting();
                Intent intent = new Intent(SettingNotificationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        setSetting();

        checkinSwitch = findViewById(R.id.checkinSwitch);
        checkinSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                LinearLayout alarmCheckin = findViewById(R.id.alarmCheckin);

                if(!isChecked){
                    alarmCheckin.setVisibility(View.GONE);
                }
                else {
                    alarmCheckin.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    public void setSetting(){

        mRequestQueue = Volley.newRequestQueue(this); //RequestQueue

        // String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, "https://protective-toes-production.up.railway.app/apiv1/setting/1", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Type settingJson = new TypeToken<Setting>() {}.getType();
                Setting setting = gson.fromJson(response, settingJson);

                checkinSwitch = findViewById(R.id.checkinSwitch);
                pointSwitch = findViewById(R.id.pointSwitch);

                if (setting.getNoticeCheckin() == 1) {
                    // If noticePoint equals 1, set the Switch to be checked (on)
                    checkinSwitch.setChecked(true);
                } else {
                    // If noticePoint does not equal 1, set the Switch to be unchecked (off)
                    checkinSwitch.setChecked(false);
                    LinearLayout alarmCheckin = findViewById(R.id.alarmCheckin);
                    alarmCheckin.setVisibility(View.GONE);
                }

                if (setting.getNoticePoint() == 1) {
                    // If noticePoint equals 1, set the Switch to be checked (on)
                    pointSwitch.setChecked(true);
                } else {
                    // If noticePoint does not equal 1, set the Switch to be unchecked (off)
                    pointSwitch.setChecked(false);
                }

                editTextNumber = findViewById(R.id.editTextNumber);
                editTextNumber.setText(String.valueOf(setting.getTimeBeforeCheckin()));

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

        mRequestQueue.add(mStringRequest);
    }

    public  void putUpdateSetting(){
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, "https://protective-toes-production.up.railway.app/apiv1/setting/1",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Handle response
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                        Toast.makeText(getApplicationContext(), "Error occurred", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            public byte[] getBody() {
                Setting setting = new Setting();
                checkinSwitch = findViewById(R.id.checkinSwitch);
                pointSwitch = findViewById(R.id.pointSwitch);
                editTextNumber = findViewById(R.id.editTextNumber);

                if (checkinSwitch.isChecked()) {
                    setting.setNoticeCheckin(1);
                } else {
                    setting.setNoticeCheckin(0);
                }

                if (pointSwitch.isChecked()) {
                    setting.setNoticePoint(1);
                } else {
                    setting.setNoticePoint(0);
                }

                setting.setTimeBeforeCheckin(Integer.parseInt(editTextNumber.getText().toString()));

                // Serialize team object to JSON
                Gson gson = new Gson();
                String json = gson.toJson(setting);

                // Send JSON data in POST request body
                return json.getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                // Add authorization token to headers
                headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuaGkiLCJyb2xlIjpbXSwiaWF0IjoxNzEyNTcyMDQ2LCJleHAiOjE3MTI1NzU2NDZ9.RSaQDA89C-83jNCdfKA0rGkc2H6BSCA-GOl42zFWMYo");
                return headers;
            }
        };

        // Add the request to the RequestQueue
        mRequestQueue.add(stringRequest);


    }
}