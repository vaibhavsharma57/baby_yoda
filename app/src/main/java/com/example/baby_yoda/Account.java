package com.example.baby_yoda;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Account extends Fragment {
    EditText enter_emergency_name,enter_contact_number ,user_name;
    Button insert_button;
    FirebaseDatabase database;
    DatabaseReference ref;
    database_model database_model;
    FirebaseAuth fAuth;

    public Account() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_account, container, false);
        enter_emergency_name = view.findViewById(R.id.enter_emergency_name);
        enter_contact_number = view.findViewById(R.id.enter_contact_number);
        insert_button = view.findViewById(R.id.insert_button);
        ListView lst = view.findViewById(R.id.list_view);
        ArrayList<MydataItems> list = new ArrayList<>();
        list.add(new MydataItems("vaibhav","988787687"));
        MyArrayAdapter adapter = new MyArrayAdapter(getActivity(),R.layout.list_view_for_account,list);
        lst.setAdapter(adapter);
        user_name = view.findViewById(R.id.user_name);
        database = FirebaseDatabase.getInstance();
        fAuth = FirebaseAuth.getInstance();
        ref = database.getReference("Users/"+ fAuth.getCurrentUser().getUid());
        database_model = new database_model();
        insert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        getValues();
                        ref.child(enter_emergency_name.getText().toString()).setValue(database_model);
                        Toast.makeText(getActivity(),"Data inserted",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        return view;
    }
    private void getValues(){
        database_model.setName(enter_emergency_name.getText().toString());
        database_model.setContact(enter_contact_number.getText().toString());
    }
}
