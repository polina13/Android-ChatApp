package com.example.guest.chatapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.chatapp.R;
import com.example.guest.chatapp.models.Message;
import com.example.guest.chatapp.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;

/**
 * Created by Guest on 5/5/16.
 */
public class FirebaseMessageListAdapter extends FirebaseRecyclerAdapter<MessageViewHolder, Message> {
    public FirebaseMessageListAdapter(Query query, Class<Message> itemClass) {
        super(query, itemClass);
    }
    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_list_item, parent, false);
        return new MessageViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        holder.bindMessage(getItem(position));
    }

    @Override
    protected void itemAdded(Message item, String key, int position) {}

    @Override
    protected void itemChanged(Message oldItem, Message newItem, String key, int position) {}

    @Override
    protected void itemRemoved(Message item, String key, int position) {}

    @Override
    protected void itemMoved(Message item, String key, int oldPosition, int newPosition) {}
}
