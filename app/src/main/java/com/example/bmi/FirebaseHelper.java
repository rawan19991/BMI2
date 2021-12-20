package com.example.bmi;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bmi.Model.BMI_Record_Model;
import com.example.bmi.Model.Food_Model;
import com.example.bmi.Model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class FirebaseHelper {
    static final FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference reference;

    public static void Creation(UserModel user, AppCompatActivity activity) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        user.setFirebaseAuth(auth);
        auth.createUserWithEmailAndPassword(user.getEmail_user(), user.getPassword())
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            CreateUserdata(user, activity);

                        } else {
                            Log.d("pron", "createUserWithEmail:success" + task.getException().getMessage());
                            Toast.makeText(activity, "Fail to add user to firebase", Toast.LENGTH_LONG).show();
                        }

                    }
                });


    }

    public static void CreateUserdata(UserModel userModel, AppCompatActivity activity) {
        try {
            DB.getCurrentUserName().setValue(userModel.getName_user())
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Intent intent = new Intent(activity, MoreInformation.class);
                            activity.startActivity(intent);
                            activity.finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(activity, "Error in Adding User Record" + e.getMessage(), Toast.LENGTH_LONG).show();

                        }
                    });


        } catch (Exception e) {
            Toast.makeText(activity, "probl" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public static void Login(AppCompatActivity activity) {
        UserModel.userModel.setFirebaseAuth(FirebaseAuth.getInstance());
        UserModel.userModel.getFirebaseAuth().signInWithEmailAndPassword(UserModel.userModel.getEmail_user(), UserModel.userModel.getPassword())
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            UserModel.userModel.setFirebaseAuth(FirebaseAuth.getInstance());
                            add_listener_touserupate(activity);
                            DB.getCurrentUser().child("Date of Last Login").setValue(new Date().toString());
                            Intent intent = new Intent(activity, HomeActivity.class);
                            activity.startActivity(intent);
                            activity.finish();
                        } else {
                            Toast.makeText(activity, "Error in Email or Password", Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }

    public static void add_listener_touserupate(AppCompatActivity activity) {
        DB.getCurrentUser().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserModel.userModel.updateList(snapshot, activity);
                HomeActivity.cheackBmiChange();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public static void Logout() {
        UserModel.userModel.getFirebaseAuth().signOut();
    }

    public static void AddBmiRecord(BMI_Record_Model model) {
        String id = DB.getCurrentUserBMIRECode().push().getKey();
        model.setId(id);
        DB.getCurrentUser().child("BMIRecords").child(id).setValue(model);
    }

    public static void AddFood(Food_Model model) {
        String id = DB.getCurrentUserFood().push().getKey();
        model.setId(id);
        DB.getCurrentUser().child("FoodList").child(id).setValue(model);
    }

    public static void RemoveFood(Food_Model model) {
        DB.getCurrentUserFood().child(model.getId()).removeValue();
    }

    public static void RemoveRecord(BMI_Record_Model model) {
        DB.getCurrentUserBMIRECode().child(model.getId()).removeValue();
    }

    public static void CompleInfromation(UserModel model, AppCompatActivity activity) {
        DB.getCurrentUserGender().setValue(model.getGender());
        DB.getCurrentUserBirth_date().setValue(model.getDate_birth());
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);

    }

    /*public static void updatefood() {


    }*/

    /*public static void getUser() {
        reference=database.getReference("FoodList");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserModel.userModel=snapshot.getValue(UserModel.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }*/

}




