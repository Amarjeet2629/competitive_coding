package org.cp.LLD.todoApp.entity;

import java.time.LocalDateTime;

public abstract class Activity {
    String id;
    LocalDateTime timestamp;
    Task task;
    ActivityEventType activityEventType;

    public Activity(String id, Task task, ActivityEventType activityEventType){
        this.id = id;
        this.task = task;
        this.timestamp = LocalDateTime.now();
        this.activityEventType = activityEventType;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Task getTask() {
        return task;
    }

    public ActivityEventType getActivityEventType(){
        return this.activityEventType;
    }
}
