package com.example.guest.chatapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.chatapp.R;
import com.example.guest.chatapp.models.Message;

import java.util.ArrayList;

/**
 * Created by Guest on 5/5/16.
 */
public class MessageListAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    private ArrayList<Message> mMessages = new ArrayList<>();
    private Context mContext;

    public MessageListAdapter(Context context, ArrayList<Message> messages) {
        this.mContext = context;
        this.mMessages = messages;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_list_item, parent, false);
        MessageViewHolder viewHolder = new MessageViewHolder(view, mMessages);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        holder.bindMessage(mMessages.get(position));
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }
}
