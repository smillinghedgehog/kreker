package com.example.tanya.kreker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessagesRecyclerAdapter extends RecyclerView.Adapter<MessageItem> {

    private Context context;
    private List<String> messages = new ArrayList<>();

    public MessagesRecyclerAdapter(@NonNull Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public MessageItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MessageItem.create(parent, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageItem holder, int position) {
        String message = messages.get(position);
        holder.bindItem(message);
    }

    public void addMessages(List<String> messages){
        this.messages.clear();
        this.messages.addAll(messages);
        notifyDataSetChanged();
    }

    public void addNewMessage(String message){
        messages.add(message);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
