package com.example.guest.chatapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guest.chatapp.Constants;
import com.example.guest.chatapp.R;
import com.example.guest.chatapp.models.User;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.realtime.util.StringListReader;

import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = CreateAccountActivity.class.getSimpleName();
    @Bind(R.id.createUserButton) Button mCreateUserButton;
    @Bind(R.id.nameEditText) EditText mNameEditText;
    @Bind(R.id.emailEditText) EditText mEmailEditText;
    @Bind(R.id.passwordEditText) EditText mPasswordEditText;
    @Bind(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;
    @Bind(R.id.loginTextView) TextView mLoginTextView;
    private Firebase mFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_accout);
        ButterKnife.bind(this);
        mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
        mCreateUserButton.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view == mCreateUserButton) {
            createNewUser();
        }
    }

    public void createNewUser() {
        final String name = mNameEditText.getText().toString();
        final String email = mEmailEditText.getText().toString();
        final String password = mPasswordEditText.getText().toString();
        final String confirmPassword = mConfirmPasswordEditText.getText().toString();

        mFirebaseRef.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                String uid = result.get("uid").toString();
                createUserInFirebaseHelper(name,email, uid);

            }

            @Override
            public void onError(FirebaseError firebaseError) {
                Log.d(TAG, "error occured " + firebaseError);
            }

            private void createUserInFirebaseHelper(final String name, final String email, final String uid) {
                final Firebase userLocation = new Firebase(Constants.FIREBASE_URL_USERS).child(uid);
                User newUser = new User(name, email);
                //use set to set the values of the user
                userLocation.setValue(newUser);
            }
        });
    }
}
