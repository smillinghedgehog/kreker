package com.example.tanya.kreker.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tanya.kreker.MessagesRecyclerAdapter;
import com.example.tanya.kreker.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {

    private List<String> messages = new ArrayList<>();
    private String message;

    private EditText newMessage;
    private ImageView sendBtn;

    private MessagesRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.messages_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference();

        RecyclerView messagesList = getView().findViewById(R.id.messages_list);
        messagesList.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MessagesRecyclerAdapter(getActivity());
        messagesList.setAdapter(adapter);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                message = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        ref.setValue("Kekas");

        messages.add(message);

        make();
        adapter.addMessages(messages);

        newMessage = getView().findViewById(R.id.new_message);
        sendBtn = getView().findViewById(R.id.send_btn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateMessages();
            }
        });
    }

    private void updateMessages(){
        String message = newMessage.getText().toString();
        newMessage.setText("");

        adapter.addNewMessage(message);
    }

    private void make(){
        messages.add("Kek");
        messages.add("KEk");
        messages.add("KEK");
    }
}
