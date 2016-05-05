package com.example.guest.chatapp.ui;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guest.chatapp.Constants;
import com.example.guest.chatapp.R;
import com.example.guest.chatapp.models.Message;
import com.firebase.client.Firebase;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.titleTextView) TextView mTitleTextView;
    @Bind(R.id.authorTextView) TextView mAuthorTextView;
    @Bind(R.id.messageTextView) TextView mMessageTextView;
    @Bind(R.id.saveMessageButton) Button mSaveMessageButton;

    private SharedPreferences mSharedPreferences;

    private Message mMessage;

    public static MessageDetailFragment newInstance(Message message) {
        MessageDetailFragment messageDetailFragment = new MessageDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("message", Parcels.wrap(message));
        messageDetailFragment.setArguments(args);
        return messageDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMessage = Parcels.unwrap(getArguments().getParcelable("message"));
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_detail, container, false);
        ButterKnife.bind(this, view);

        mTitleTextView.setText(mMessage.getTitle());
        mAuthorTextView.setText(mMessage.getUser());
        mMessageTextView.setText(mMessage.getMessage());

        mSaveMessageButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == mSaveMessageButton) {
            String userUid = mSharedPreferences.getString(Constants.KEY_UID, null);
            Firebase userMessagesFirebaseRef = new Firebase(Constants.FIREBASE_URL_MESSAGES).child(userUid);
            Firebase pushRef = userMessagesFirebaseRef.push();
            String messagePushId = pushRef.getKey();
            mMessage.setPushId(messagePushId);
            userMessagesFirebaseRef.push().setValue(mMessage);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}