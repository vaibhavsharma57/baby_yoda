package com.example.baby_yoda;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class login_page extends AppCompatActivity {
    EditText enter_user_name , enter_password;
    Button login_button , register_button;
    FirebaseAuth fAuth;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login_page);
            enter_user_name = findViewById(R.id.enter_username);
            enter_password = findViewById(R.id.enterpassword);
            login_button = findViewById(R.id.login_button);
            register_button = findViewById(R.id.register_button);
        fAuth = FirebaseAuth.getInstance();
            register_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(login_page.this,registration.class);
                    startActivity(intent);
                }
            });
            login_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email = enter_user_name.getText().toString().trim();
                    String password = enter_password.getText().toString().trim();
                    if(TextUtils.isEmpty(email))
                    {
                        enter_user_name.setError("EMAIL ID IS A REQUIRED FIELD");
                        return;
                    }
                    if(TextUtils.isEmpty(password))
                    {
                        enter_user_name.setError("PASSWORD IS A REQUIRED FIELD");
                        return;
                    }
                    fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(login_page.this,"Succesfully logged in",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(login_page.this,"Succesfully not logged in",Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
                }
            });


    }
}
