package com.example.guest.chatapp.ui;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.guest.chatapp.Constants;
import com.example.guest.chatapp.R;
import com.example.guest.chatapp.adapters.FirebaseMessageListAdapter;
import com.example.guest.chatapp.models.Message;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedMessageListActivity extends AppCompatActivity {
    private Query mQuery;
    private Firebase mFirebaseMessageRef;
    private FirebaseMessageListAdapter mAdapter;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);
        ButterKnife.bind(this);

        mFirebaseMessageRef = new Firebase(Constants.FIREBASE_URL_MESSAGES);
        setUpFirebaseQuery();
        setUpRecyclerView();
    }


    private void setUpFirebaseQuery() {
        String message = mFirebaseMessageRef.toString();
        mQuery = new Firebase(message);
    }
    private void setUpRecyclerView() {
        mAdapter = new FirebaseMessageListAdapter(mQuery, Message.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}
