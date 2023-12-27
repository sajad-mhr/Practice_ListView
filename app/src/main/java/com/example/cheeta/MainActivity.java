package com.example.cheeta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView contactlist;
        contactlist = (ListView)findViewById(R.id.contactList);
        AlertDialog.Builder alertBuilder;
        alertBuilder = new AlertDialog.Builder(this);
        Intent intent = new Intent(MainActivity.this,MessagesActivity.class);

        ArrayList<ContactModel> contact_model = new ArrayList<ContactModel>();

        for (int i = 1;i<=50;i++){
            contact_model.add(new ContactModel(i,"user_"+i,R.drawable.profile,"text message_"+i));
        }
        ContactAdapter contact_adapter = new ContactAdapter(this,contact_model);
        contactlist.setAdapter(contact_adapter);

        contactlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel cm;
                cm = (ContactModel) parent.getItemAtPosition(position);

                alertBuilder.setTitle("Do you want to open "+cm.getName()+"'s chat?");
                alertBuilder.setIcon(R.mipmap.ic_launcher_round);
                alertBuilder.create();

                alertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ContactModel cm;
                        cm = (ContactModel) parent.getItemAtPosition(position);
                        intent.putExtra("message",cm.getMessage());
                        intent.putExtra("name",cm.getName());
                        intent.putExtra("img",cm.getImg());
                        startActivity(intent);
                    }
                });

                alertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });


                alertBuilder.show();
            }
        });
    }
}