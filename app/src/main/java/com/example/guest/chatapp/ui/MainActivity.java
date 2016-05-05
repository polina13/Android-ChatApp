package com.example.guest.chatapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guest.chatapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.newMessageButton) Button mNewMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mNewMessageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mNewMessageButton) {
            Intent intent = new Intent(MainActivity.this, NewMessageActivity.class);
            startActivity(intent);
        }
    }
}
