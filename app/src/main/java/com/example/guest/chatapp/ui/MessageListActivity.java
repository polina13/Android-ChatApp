
package com.example.guest.chatapp.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.guest.chatapp.Constants;
import com.example.guest.chatapp.R;
import com.example.guest.chatapp.adapters.FirebaseMessageListAdapter;
import com.example.guest.chatapp.adapters.MessageListAdapter;
import com.example.guest.chatapp.models.Message;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessageListActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
   private FirebaseMessageListAdapter mAdapter;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mSharedPreferencesEditor;
    private ArrayList<Message> messages = new ArrayList<>();
    private Firebase mFirebaseMessageRef;
    private Query mQuery = new Firebase(Constants.FIREBASE_URL_MESSAGES);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);
        Intent intent = getIntent();
        ButterKnife.bind(this);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String text = intent.getStringExtra("message");
        String title = intent.getStringExtra("title");
        String author = intent.getStringExtra("author");

        Message message = new Message(text, title, author);

        saveToFirebase(message);
        displayList();
    }

    public void displayList() {
        mAdapter = new FirebaseMessageListAdapter(mQuery, Message.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    public void saveToFirebase(Message message) {
        String userUid = mSharedPreferences.getString(Constants.KEY_UID, null);
        Firebase userMessagesFirebaseRef = new Firebase(Constants.FIREBASE_URL_MESSAGES).child(userUid);
        Firebase pushRef = userMessagesFirebaseRef.push();
        String messagePushId = pushRef.getKey();
        message.setPushId(messagePushId);
        messages.add(message);
        userMessagesFirebaseRef.push().setValue(message);
    }
}
