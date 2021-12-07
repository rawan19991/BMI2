package com.example.bmi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bmi.Edit_Food_Details;
import com.example.bmi.Food_list;
import com.example.bmi.HomeActivity;
import com.example.bmi.Model.Food_Model;
import com.example.bmi.Model.UserModel;
import com.example.bmi.R;
import com.example.bmi.new_record;

import java.util.ArrayList;

public class Food_Adapter extends RecyclerView.Adapter<Food_Adapter.view_adapter> {
    ArrayList<Food_Model> list;
    Context context;

    public Food_Adapter(ArrayList<Food_Model> list, Context context) {
        this.list = list;
        this.context = context;
    } {

    }

    @NonNull
    @Override
    public view_adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_food_lisy,parent,false);
        return new view_adapter(view);    }

    @Override
    public void onBindViewHolder(@NonNull Food_Adapter.view_adapter holder, int position) {
        final Food_Model model=list.get(position);
        holder.food_img.setImageResource(model.getFood_img());
        holder.food_name.setText(model.getFood_name());
        holder.food_catogries.setText(model.getFood_catogries());
        holder.food_calory.setText(model.getCalory());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Edit_Food_Details.class);
               intent.putExtra("foods",model.getFood_name());
                intent.putExtra("images",model.getFood_img());
                intent.putExtra("catos",model.getFood_catogries());
                intent.putExtra("calos",model.getCalory());
                context.startActivity(intent);
            }
        });


    }



    @Override
    public int getItemCount() {
        return list.size();

    }

    public class view_adapter extends RecyclerView.ViewHolder {
        Button edit,deletee_food;
        ImageView food_img;
        TextView food_name,food_catogries,food_calory;
        public view_adapter(@NonNull View itemView) {
            super(itemView);
            food_img=itemView.findViewById(R.id.food_imgg);
            food_name=itemView.findViewById(R.id.Foodname);
            food_catogries=itemView.findViewById(R.id.food_catogries);
            food_calory=itemView.findViewById(R.id.calory);
            edit=itemView.findViewById(R.id.edit_food);
            deletee_food=itemView.findViewById(R.id.delete_food);
        }
    }


}
