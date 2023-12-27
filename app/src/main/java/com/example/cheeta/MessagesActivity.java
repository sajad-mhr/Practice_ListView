package com.example.cheeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MessagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        Intent intent = getIntent();
        String value_name = intent.getStringExtra("name");
        String value_message = intent.getStringExtra("message");
        int value_profile = intent.getIntExtra("img",0);
        TextView name = (TextView) findViewById(R.id.name);
        TextView message = (TextView) findViewById(R.id.messages);
        ImageView profile = (ImageView) findViewById(R.id.profile);
        name.setText(value_name);
        message.setText(value_message);
        profile.setImageResource(value_profile);
    }
}