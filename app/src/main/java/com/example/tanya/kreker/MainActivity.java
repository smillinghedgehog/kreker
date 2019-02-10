package com.example.tanya.kreker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tanya.kreker.fragments.MessageFragment;

public class MainActivity extends AppCompatActivity {

    private String MESSAGE = "MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_frame, new MessageFragment())
                .addToBackStack(MESSAGE)
                .commit();
    }
}
