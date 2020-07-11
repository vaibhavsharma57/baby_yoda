package com.example.baby_yoda;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Calorimeter extends Fragment  {
    RadioButton male_radio_button,female_radio_button;
    EditText age,height,weight,position;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    float BMR,BMI ;

    public Calorimeter() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_calorimeter, container, false);
        male_radio_button = v.findViewById(R.id.male_radio_button);
        female_radio_button = v.findViewById(R.id.female_radio_button);
        age = v.findViewById(R.id.enter_age);
        position = v.findViewById(R.id.position);
        height = v.findViewById(R.id.enter_height);
        weight = v.findViewById(R.id.enter_weight);
        Spinner spinner = v.findViewById(R.id.activity_spinner);
         pref = getActivity().getSharedPreferences("calorimeter", Context.MODE_PRIVATE);
        editor = pref.edit();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.activities,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        if(male_radio_button.isSelected()){
            String ages = age.getText().toString();
            float age = Float.parseFloat(ages);
            String weights = weight.getText().toString();
            float weight = Float.parseFloat(weights);
            String heights = height.getText().toString();
            float height = Float.parseFloat(heights);
             BMR = (float) (((10 * weight) + (6.25 * height)) - (5 * age) + 5);
             BMI = (float) (weight / (height*height*0.01*0.01));
        }
        else if(female_radio_button.isSelected()){
            String ages = age.getText().toString();
            float age = Float.parseFloat(ages);
            String weights = weight.getText().toString();
            float weight = Float.parseFloat(weights);
            String heights = height.getText().toString();
            float height = Float.parseFloat(heights);
             BMR = (float) (((10 * weight) + (6.25 * height)) - (5 * age) -161);
            BMI = (float) (weight / (height*height*0.01*0.01));
        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = adapterView.getItemAtPosition(i).toString();
                position.setText(text);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getActivity(),"PLEASE SELECT ACTIVITY",Toast.LENGTH_SHORT).show();

            }
        });
       String text = position.getText().toString();
        if(text.equals("Basal Metabolic Rate(BMR)")){
            editor.putFloat("bmr",BMR);
        }
        else if (text.equals("Sedentry: Little or no exercise")){
            editor.putFloat("calory", (float) (BMR*1.2));

        }
        else if(text.equals("Light: Exercise 1-3 times/week")){
            editor.putFloat("calory", (float) (BMR*1.375));
        }
        else if(text.equals("Moderate: Exercise 4-5 times/week")){
            editor.putFloat("calory", (float) (BMR*1.55));
        }
        else if(text.equals("Active: Daily exercise or intense exercise 3-4 times/week")){
            editor.putFloat("calory", (float) (BMR*1.6));
        }
        else if(text.equals("Very active: Intense exercise 6-7 times/week")){
            editor.putFloat("calory", (float) (BMR*1.725));
        }
        else if(text.equals("Extra Active: very intense exercise daily, or physical job")){
            editor.putFloat("calory", (float) (BMR*1.9));
        }
        editor.apply();


                return v;
    }


}
