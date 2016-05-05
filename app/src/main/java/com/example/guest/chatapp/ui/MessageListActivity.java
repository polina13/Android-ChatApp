
package com.example.guest.chatapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.guest.chatapp.R;
import com.example.guest.chatapp.adapters.MessageListAdapter;
import com.example.guest.chatapp.models.Message;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessageListActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
   private MessageListAdapter mAdapter;

    private ArrayList<Message> messages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);
        Intent intent = getIntent();
        ButterKnife.bind(this);

        String text = intent.getStringExtra("message");
        String title = intent.getStringExtra("title");
        String author = intent.getStringExtra("author");

        Message message = new Message(text, title, author);
        messages.add(message);
        displayList();
    }

    public void displayList() {
        ArrayList<Message> messageArray = this.messages;
        mAdapter = new MessageListAdapter(getApplicationContext(), messageArray);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MessageListActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
    }
}
