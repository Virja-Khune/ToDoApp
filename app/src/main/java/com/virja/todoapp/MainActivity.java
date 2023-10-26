package com.virja.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.virja.todoapp.DATA.DataClass;
import com.virja.todoapp.DATA.DataStorage;
import com.virja.todoapp.DATA.TodoAdapter;
import com.virja.todoapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());
        //getSupportActionBar().hide();

        RecyclerView recyclerView = findViewById(R.id.rvTasks);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false
        );
        recyclerView.setLayoutManager(linearLayoutManager);

        TodoAdapter adapter = new TodoAdapter(DataStorage.getData(),this);

        recyclerView.setAdapter(adapter);


        Button addbutton = findViewById(R.id.btnNewTask);
        EditText tasks = findViewById(R.id.etNewTask);
        addbutton.setOnClickListener(v -> {
            DataStorage.setData(new DataClass(tasks.getText().toString(), false));
            adapter.notifyDataSetChanged();
            tasks.setText("");
        });


    }
}