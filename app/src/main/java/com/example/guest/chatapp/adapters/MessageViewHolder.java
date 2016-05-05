package com.example.guest.chatapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.guest.chatapp.R;
import com.example.guest.chatapp.models.Message;
import com.example.guest.chatapp.ui.MessageDetailActivity;

import org.parceler.Parcels;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/5/16.
 */
public class MessageViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.titleTextView) TextView mTitleTextView;
    @Bind(R.id.authorTextView) TextView mAuthorTextView;
    @Bind(R.id.messageTextView) TextView mMessageTextView;

    private Context mContext;
    private ArrayList<Message> mMessages = new ArrayList<>();


    public MessageViewHolder(View itemView, ArrayList<Message> messages) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mMessages = messages;

        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, MessageDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("messages", Parcels.wrap(mMessages));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindMessage(Message message) {
        mTitleTextView.setText(message.getTitle());
        mAuthorTextView.setText(message.getUser());
        mMessageTextView.setText(message.getMessage());
    }
}
