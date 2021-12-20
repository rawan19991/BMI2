package com.example.bmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bmi.Model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpScreen extends AppCompatActivity {
TextView login;
EditText user_email,userpassword,user_name,repassword;
    Button sign;
   FirebaseHelper helpers;
  FirebaseAuth mAuth;
final  FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
     final DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        getSupportActionBar().setTitle("BMI Analyzer");
        login=findViewById(R.id.login);
        sign = findViewById(R.id.create);
        user_email = findViewById(R.id.userEmailEdit);
        userpassword = findViewById(R.id.userpassword);
        user_name = findViewById(R.id.userNameEdit);
        repassword = findViewById(R.id.repassword);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(SignUpScreen.this,LoginScreen.class);
                startActivity(i);
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            final String email = user_email.getText().toString().trim();
                  final String password = userpassword.getText().toString().trim();
                 final String ePassword = repassword.getText().toString().trim();
                  final String name = user_name.getText().toString().trim();

                if (email.isEmpty()) {
                    user_email.setError("Please Add Email");
                    user_email.requestFocus();
                } else if (name.isEmpty()) {
                    user_name.setError("Please Add Name");
                    user_name.requestFocus();
                } else if (password.isEmpty()) {
                    userpassword.setError("Please Add Password");
                    userpassword.requestFocus();
                } else if (ePassword.isEmpty()) {
                    repassword.setError("Please Add Email");
                    repassword.requestFocus();
                } else if (!password.equals(ePassword)) {
                    repassword.setError("The password does not match");
                }
                UserModel.userModel= new UserModel(name,email,password,ePassword,SignUpScreen.this);
                helpers.Creation(UserModel.userModel,SignUpScreen.this);
            }       });










    }
    /*private void createAccount(String email, String password) {
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(  SignUpScreen.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("FirebaseAuth", "createUserWithEmail:success"+task.getException().getMessage());
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("hi", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpScreen.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });}*/

    private void updateUI(FirebaseUser user) {

    }
}


