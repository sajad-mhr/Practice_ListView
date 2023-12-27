package com.example.cheeta;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {

    Context context;
    ArrayList<ContactModel> array;

    public ContactAdapter(Context context, ArrayList<ContactModel> array) {
        this.context = context;
        this.array = array;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int i) {
        return array.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = LayoutInflater.from(context).inflate(R.layout.contact_list,viewGroup,false);

        ContactModel contact_model = (ContactModel) getItem(i);

        TextView name = (TextView) v.findViewById(R.id.contact_name);
        TextView message = (TextView) v.findViewById(R.id.message);
        ImageView img = (ImageView) v.findViewById(R.id.contact_img);


        name.setText(contact_model.getName());
        if(contact_model.getMessage().length() > 20){
            message.setText(contact_model.getMessage().substring(0,20)+"...");
        }else {
            message.setText(contact_model.getMessage());
        }
        img.setImageResource(contact_model.getImg());

        return v;
    }
}
