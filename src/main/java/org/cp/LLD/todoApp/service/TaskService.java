package org.cp.LLD.todoApp.service;

import org.cp.LLD.todoApp.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TaskService {
    List<Task> taskList;

    public TaskService(){
        this.taskList = new ArrayList<>();
    }

    public void addTask(Task task){
        this.taskList.add(task);
    }

    public Task getTaskById(int taskId){
        for (Task task : taskList) {
            if (taskId == task.getId()) {
                return task.getCopy();
            }
        }

        return null;
    }

    public void modifyTask(Task task){
        for(int i = 0; i < taskList.size(); i++){
            if(task.getId() == taskList.get(i).getId()){
                taskList.set(i, task);
            }
        }
    }

    public void removeTask(int taskId){
        Task task = getTaskById(taskId);
        taskList.remove(task);
    }

    public List<Task> getAllTaskByFilter(List<Predicate<Task>> filters){
        if(filters == null) return taskList;

        return taskList
                .stream()
                .filter(task ->
                        filters.stream()
                                .allMatch(
                                        filter -> filter.test(task)))
                .toList();
    }

    public int getTaskCount(){
        return this.taskList.size();
    }

}
