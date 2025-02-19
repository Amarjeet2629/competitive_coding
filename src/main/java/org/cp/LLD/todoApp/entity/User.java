package org.cp.LLD.todoApp.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String name;
    List<Task> todoList;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.todoList = new ArrayList<>();
    }

    public void addTask(Task task){
        this.todoList.add(task);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTodoList() {
        return todoList;
    }

    public void removeTask(Task task){
        todoList.remove(task);
    }
}
