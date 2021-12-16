package com.example.bmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bmi.Model.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginScreen extends AppCompatActivity {
TextView signup;
Button login;
EditText email,password;
FirebaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        getSupportActionBar().setTitle("BMI Analyzer");
        signup=findViewById(R.id.sign_up);
        login=findViewById(R.id.login_button);
        email=findViewById(R.id.editTextTextPersonName);
        password=findViewById(R.id.editTextTextPassword);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              String emailss=email.getText().toString();
                String Pass=password.getText().toString();
                UserModel.userModel=new UserModel(emailss,Pass);
               helper.Login(LoginScreen.this);



            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginScreen.this,SignUpScreen.class);
                startActivity(i);

            }
        });
    }

   /* private void moveToHomeActivity(FirebaseUser firebaseUser) {
        firebaseDatabase.getReference().child(firebaseUser.getUid()).
        addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserModel model=snapshot.getValue(UserModel.class);
                String name=
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        })
        ;
    }*/
}