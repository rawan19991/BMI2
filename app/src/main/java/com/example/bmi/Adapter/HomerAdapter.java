package com.example.bmi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bmi.Model.BMI_Record_Model;
import com.example.bmi.Model.UserModel;
import com.example.bmi.R;
import java.util.ArrayList;

public class HomerAdapter extends RecyclerView.Adapter<HomerAdapter.view_adapter> {
    UserModel userModel;
    Context context;

    public HomerAdapter(UserModel list, Context context) {
        this.userModel = list;
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
        BMI_Record_Model usermodel=userModel.bmiRecordModels.get(position);
        holder.weight.setText(usermodel.getWeight());
        holder.length.setText(usermodel.getLength());
        holder.status.setText(usermodel.getStatus());
        holder.date.setText(usermodel.getDate());

    }



    @Override
    public int getItemCount() {
        return userModel.bmiRecordModels.size();

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

