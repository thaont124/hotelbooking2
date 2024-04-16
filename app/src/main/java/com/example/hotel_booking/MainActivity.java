package com.example.hotel_booking;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.net.URI;
import java.net.URISyntaxException;

import dev.gustavoavila.websocketclient.WebSocketClient;

public class MainActivity extends AppCompatActivity {
    private WebSocketClient client;
    private int notificationId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        connectWebSocket();
        // Toolbar setup
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView settingsIcon = findViewById(R.id.settings_icon);

        settingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý các hành động khi biểu tượng cài đặt được nhấp
                // Ví dụ: mở màn hình cài đặt
                Intent intent = new Intent(MainActivity.this, SettingNotificationActivity.class);
                startActivity(intent);
            }
        });

        // Navigation setup
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_history, R.id.navigation_notifications, R.id.navigation_account)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "channel_1";
            String description = "channel_description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("CHANNEL_1", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


    private void connectWebSocket() {
        Thread n= new Thread(new Runnable() {
            @Override
            public void run() {
                URI uri;
                try {
                    uri = new URI("ws://192.168.185.98:8000/ws/notification/1/");
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                    return;
                }

                client = new WebSocketClient(uri) {
                    @Override
                    public void onOpen() {
                        Log.d("WebSocket", "Connected to server");
                    }

                    @Override
                    public void onTextReceived(String s) {
                        Log.d("d", s);
                        showNotification(s);
                    }

                    @Override
                    public void onBinaryReceived(byte[] bytes) {
                        Log.d("btte", "d");
                    }

                    @Override
                    public void onPingReceived(byte[] bytes) {
                        Log.d("Ping", "d");
                    }

                    @Override
                    public void onPongReceived(byte[] bytes) {
                        Log.d("Pong", "d");
                    }

                    @Override
                    public void onException(Exception e) {
                        Log.d("exp", "d");
                    }

                    @Override
                    public void onCloseReceived(int i, String s) {
                        Log.d("close", "d");
                    }


                };

                client.connect();
            }
        });
        n.start();

    }

    private void showNotification(String message) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,
                "CHANNEL_1")
                .setContentTitle("Thong Bao")
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_alarm)
                .setColor(Color.RED)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .setDefaults(NotificationCompat.DEFAULT_SOUND);

        // Kiểm tra quyền trước khi hiển thị thông báo
        // Nếu quyền đã được cấp, hiển thị thông báo
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        managerCompat.notify(notificationId, builder.build());




    }
}