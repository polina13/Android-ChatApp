package com.example.guest.chatapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.guest.chatapp.models.Message;
import com.example.guest.chatapp.ui.MessageDetailActivity;
import com.example.guest.chatapp.ui.MessageDetailFragment;

import java.util.ArrayList;

/**
 * Created by Guest on 5/5/16.
 */
public class MessagePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Message> mMessages;

    public MessagePagerAdapter(FragmentManager fm, ArrayList<Message> messages) {
        super(fm);
        this.mMessages = messages;
    }

    @Override
    public Fragment getItem(int position) {
        return MessageDetailFragment.newInstance(mMessages.get(position));
    }

    @Override
    public int getCount() {
        return mMessages.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mMessages.get(position).getTitle();
    }
}
