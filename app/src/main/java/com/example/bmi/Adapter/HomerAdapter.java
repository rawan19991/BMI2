package com.example.bmi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bmi.DB;
import com.example.bmi.FirebaseHelper;
import com.example.bmi.Model.BMI_Record_Model;
import com.example.bmi.Model.UserModel;
import com.example.bmi.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomerAdapter extends RecyclerView.Adapter<HomerAdapter.view_adapter> {
FirebaseHelper helper;
    Context context;
    ArrayList<BMI_Record_Model> modelss;

    public HomerAdapter(  ArrayList<BMI_Record_Model> models,Context context) {
      modelss= models;
        this.context = context;
    } {

}

    @NonNull
    @Override
    public view_adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.view_status,parent,false);
        return new view_adapter(view);    }

    @Override
    public void onBindViewHolder(@NonNull HomerAdapter.view_adapter holder, int position) {
        BMI_Record_Model usermodel=modelss.get(position);
        holder.weight.setText(usermodel.getWeight());
        holder.length.setText(usermodel.getLength());
        holder.status.setText(usermodel.getStatus());
        holder.date.setText(usermodel.getDate());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                helper.RemoveRecord(usermodel);
                return false;
            }
        });
    }



    @Override
    public int getItemCount() {
        return modelss.size();

    }

public class view_adapter extends RecyclerView.ViewHolder {
    TextView date,weight,length,status;
    public view_adapter(@NonNull View itemView) {
        super(itemView);
        date=itemView.findViewById(R.id.date);
        weight=itemView.findViewById(R.id.weight);
        length=itemView.findViewById(R.id.lenght);
        status=itemView.findViewById(R.id.status);
    }
}


}

