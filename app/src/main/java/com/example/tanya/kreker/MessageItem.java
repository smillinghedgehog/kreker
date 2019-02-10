package com.example.tanya.kreker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MessageItem extends RecyclerView.ViewHolder {

    private Context context;
    private TextView textView;

    public static MessageItem create(@NonNull ViewGroup parent, Context context){
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new MessageItem(view, context);
    }

    private MessageItem(@NonNull View itemView, Context context){
        super(itemView);
        this.context = context;
        textView = itemView.findViewById(R.id.message_text);
    }

    public void bindItem(@NonNull String text){
        textView.setText(text);
    }
}
