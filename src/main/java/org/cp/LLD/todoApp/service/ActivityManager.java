package org.cp.LLD.todoApp.service;

import org.cp.LLD.todoApp.entity.Activity;
import org.cp.LLD.todoApp.entity.ActivityEventType;
import org.cp.LLD.todoApp.entity.Task;
import org.cp.LLD.todoApp.entity.impl.AdditionEvent;
import org.cp.LLD.todoApp.entity.impl.CompletionEvent;
import org.cp.LLD.todoApp.entity.impl.ModificationEvent;
import org.cp.LLD.todoApp.entity.impl.RemovalEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityManager {
    List<Activity> activityList;

    public ActivityManager(){
        this.activityList = new ArrayList<>();
    }

    public void addNewActivity(ActivityEventType activityEventType, Task task){
        switch (activityEventType){
            case REMOVAL -> {
                activityList.add(new RemovalEvent(System.currentTimeMillis() + "-" + task.getId(), task));
            }

            case ADDITION -> {
                activityList.add(new AdditionEvent(System.currentTimeMillis() + "-" + task.getId(), task));
            }

            case COMPLETION -> {
                activityList.add(new CompletionEvent(System.currentTimeMillis() + "-" + task.getId(), task));
            }

            case MODIFICATION -> {
                activityList.add(new ModificationEvent(System.currentTimeMillis() + "-" + task.getId(), task));
            }

            default -> {
                return;
            }
        }

    }

    public List<Activity> getActivityListInRange(LocalDateTime startTime, LocalDateTime endTime){
        return activityList.stream().filter(activity -> {
            if(activity.getTimestamp().isAfter(startTime) && activity.getTimestamp().isBefore(endTime)) return true;

            return false;
        }).toList();
    }

    public List<Activity> getAllActivityList(){
        return this.activityList;
    }
}
