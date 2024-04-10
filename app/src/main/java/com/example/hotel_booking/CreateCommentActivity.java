package com.example.hotel_booking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class CreateCommentActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_comment);

        TextInputLayout textInputLayout = findViewById(R.id.text_input_layout);
        EditText editText = findViewById(R.id.type);

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    textInputLayout.setHint(" "); // Xóa hint khi EditText được tập trung
                } else {
                    textInputLayout.setHint("Hãy nhập bình luận"); // Hiển thị hint khi EditText không được tập trung
                }
            }
        });

        Button button = findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateCommentActivity.this, CommentActivity.class);
                startActivity(intent);
            }
        });;

    }
}