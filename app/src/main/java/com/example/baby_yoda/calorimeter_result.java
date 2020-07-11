package com.example.baby_yoda;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class calorimeter_result extends Fragment {
    TextView bmr_view, calory_need;
    SharedPreferences pref;


    public calorimeter_result() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_calorimeter_result, container, false);
        bmr_view = v.findViewById(R.id.bmr_view);
        calory_need = v.findViewById(R.id.calory_need);
        pref = getActivity().getSharedPreferences("calorimeter", MODE_PRIVATE);
       final float bmr = pref.getFloat("bmr",0);
        final float calory = pref.getFloat("calory",0);


        return v;
    }
}
