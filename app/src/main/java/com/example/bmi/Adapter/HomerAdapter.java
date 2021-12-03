package com.example.bmi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bmi.Model.UserModel;
import com.example.bmi.R;
import java.util.ArrayList;

public class HomerAdapter extends RecyclerView.Adapter<HomerAdapter.view_adapter> {
    ArrayList<UserModel> list;
    Context context;

    public HomerAdapter(ArrayList<UserModel> list, Context context) {
        this.list = list;
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
        final UserModel model=list.get(position);
        holder.weight.setText(model.getWeight());
        holder.length.setText(model.getLength());
        holder.status.setText(model.getStatus());
        holder.date.setText(model.getDate());

    }



    @Override
    public int getItemCount() {
        return list.size();

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

