package com.example.guest.chatapp.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.guest.chatapp.R;
import com.example.guest.chatapp.adapters.MessagePagerAdapter;
import com.example.guest.chatapp.models.Message;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessageDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private MessagePagerAdapter adapterViewPager;
    ArrayList<Message> mMessages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);
        ButterKnife.bind(this);

        mMessages = Parcels.unwrap(getIntent().getParcelableExtra("messages"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new MessagePagerAdapter(getSupportFragmentManager(), mMessages);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);

        Toast.makeText(MessageDetailActivity.this, "reach here", Toast.LENGTH_SHORT).show();
    }
}
