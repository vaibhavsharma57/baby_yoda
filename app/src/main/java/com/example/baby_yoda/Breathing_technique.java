package com.example.baby_yoda;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Breathing_technique extends Fragment {
Button exercise1, exercise2 , exercise3;
EditText exercises;
    public Breathing_technique() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_breathing_technique, container, false);
        exercise1 = v.findViewById(R.id.exercise1);
        exercise2 = v.findViewById(R.id.exercise2);
        exercise3 = v.findViewById(R.id.exercise3);
        exercises = v.findViewById(R.id.exercises);
        exercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first = String.format("Ideally, sit with your back straight.\nPlace the tip of your tongue against the ridge of tissue just behind your upper front teeth, and keep it there through the entire exercise.\nExhale through your mouth around your tongue; try pursing your lips slightly if this seems awkward.\nExhale completely through your mouth, making a whoosh sound.\nClose your mouth and inhale quietly through your nose to a mental count of 4.\nHold your breath for a count of 7.\nExhale completely through your mouth, making a whoosh sound to a count of 8.\nThis is one breath. Now inhale again and repeat the cycle three more times for a total of four breaths.\n");
                exercises.setText(first);
            }
        });
        exercise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String second = String.format("When deep breathing is focused and slow, it can help reduce anxiety. You can do this technique by sitting or lying down in a quiet, comfortable location.\n\nNotice how it feels when you inhale and exhale normally. Mentally scan your body. You might feel tension in your body that you never noticed.\nTake a slow, deep breath through your nose.\nNotice your belly and upper body expanding.\nExhale in whatever way is most comfortable for you, sighing if you wish.\nDo this for several minutes, paying attention to the rise and fall of your belly.\nChoose a word to focus on and vocalize during your exhale. Words like “safe” and “calm” can be effective.\nImagine your inhale washing over you like a gentle wave.\nImagine your exhale carrying negative and upsetting thoughts and energy away from you.\nWhen you get distracted, gently bring your attention back to your breath and your words.\nPractice this technique for up to 20 minutes daily when you can.\n");
                exercises.setText(second);
            }
        });
        exercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String third = ""
            }
        });

        return v;
    }
}
