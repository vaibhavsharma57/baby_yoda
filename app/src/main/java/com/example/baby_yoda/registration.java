package com.example.baby_yoda;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registration extends AppCompatActivity {
    EditText enter_user_name, enter_email, enter_password, enter_phone_number;
    private FirebaseAuth fAuth;;
    Button registerbutton;
    private static final String TAG = "EmailPassword";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        enter_user_name = findViewById(R.id.enter_user_name);
        enter_email = findViewById(R.id.enter_email_id);
        enter_password = findViewById(R.id.enter_password);
        enter_phone_number = findViewById(R.id.enter_phone_number);
        registerbutton = findViewById(R.id.registerbutton);
        fAuth = FirebaseAuth.getInstance();
        if (fAuth.getCurrentUser() != null){

        }
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = enter_user_name.getText().toString().trim();
                String email = enter_email.getText().toString().trim();
                String password = enter_password.getText().toString().trim();
                if(TextUtils.isEmpty(email))
                {
                    enter_email.setError("EMAIL ID IS A REQUIRED FIELD");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    enter_email.setError("PASSWORD IS A REQUIRED FIELD");
                    return;
                }
                else if(TextUtils.isEmpty(username))
                {
                    enter_user_name.setError("USERNAME IS REQUIRED");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(registration.this,"Succesfully registered",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(registration.this,"Succesfully not registered",Toast.LENGTH_SHORT).show();

                        }

                    }
                });

            }
        });




    }

}