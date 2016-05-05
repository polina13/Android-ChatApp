package com.example.guest.chatapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.guest.chatapp.R;

public class MessageDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);

        Toast.makeText(MessageDetailActivity.this, "reach here", Toast.LENGTH_SHORT).show();
    }
}
