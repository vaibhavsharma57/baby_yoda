package com.example.baby_yoda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<MydataItems> {
    Context context;
    LayoutInflater inflater;
    ArrayList<MydataItems> items;
    int resource;
    public MyArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MydataItems> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        items = objects;
    }
        @NonNull
        @Override
        public View getView(int position,@Nullable View convertView, @NonNull ViewGroup parent){
        inflater = LayoutInflater.from(context);
            if (convertView==null){
                convertView = inflater.inflate(resource,parent,false);
            }
            MydataItems item = items.get(position);
            TextView name = convertView.findViewById(R.id.name);
            TextView contact_number = convertView.findViewById(R.id.contact_number);
            name.setText(item.getName());
            contact_number.setText(item.getContact_number());
            return convertView;

    }
}
