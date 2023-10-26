package com.virja.todoapp.DATA;

import java.util.ArrayList;

public class DataStorage {
    private static ArrayList<DataClass> data = new ArrayList<>();

    public static ArrayList<DataClass> getData() {
        return data;
    }

    public static void setData(DataClass new_data) {
      data.add(new_data);
    }

    public static void delData(int index) {
        data.remove(index);
    }
}