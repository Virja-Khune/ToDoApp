package com.virja.todoapp.DATA;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.virja.todoapp.R;

import java.util.ArrayList;


public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.viewHolder> {
    Context context;

    public TodoAdapter(ArrayList<DataClass> data, Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_todo_item, parent, false);
        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ArrayList<DataClass> data = DataStorage.getData();

        holder.todoItem.setText(data.get(position).task);
        holder.chkTodo.setChecked(data.get(position).isDone);
        holder.btnToDo.setOnClickListener(
                v->{
                    DataStorage.delData(position);
                    notifyDataSetChanged();
                }
        );
    }


    @Override
    public int getItemCount() {
        return DataStorage.getData().size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        //ImageView imageView;
        CheckBox chkTodo;
        ImageButton btnToDo;
        TextView todoItem;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            //imageView = itemView.findViewById(R.id.todoCheckBox);
            chkTodo = itemView.findViewById(R.id.todoCheckBox);
            btnToDo = itemView.findViewById(R.id.imgBtnToDo);
            todoItem = itemView.findViewById(R.id.todoTV);
        }
    }
}


