package com.example.guest.chatapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guest.chatapp.R;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewMessageActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.titleEditText) EditText mTitleEditText;
    @Bind(R.id.messageEditText) EditText mMessageEditText;
    @Bind(R.id.saveMessageButton) Button mSaveMessageButton;
    @Bind(R.id.authorEditText) EditText mAuthorEditText;

    private Firebase mFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        ButterKnife.bind(this);
       mSaveMessageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mSaveMessageButton) {
            String message = mMessageEditText.getText().toString();
            String title = mTitleEditText.getText().toString();
            String author = mAuthorEditText.getText().toString();
            Intent intent = new Intent(NewMessageActivity.this, MessageListActivity.class);
            intent.putExtra("message", message);
            intent.putExtra("title", title);
            intent.putExtra("author", author);
            startActivity(intent);
        }
    }
}
