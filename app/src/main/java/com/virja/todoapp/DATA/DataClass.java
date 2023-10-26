package com.virja.todoapp.DATA;

import java.io.Serializable;
import java.lang.String;

public class DataClass{
    String task;

    Boolean isDone;

    public DataClass(String task,Boolean isDone){

        this.task = task;
        this.isDone = isDone;
    }
}

