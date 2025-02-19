package org.cp.LLD.todoApp.service;

import org.cp.LLD.todoApp.entity.Activity;
import org.cp.LLD.todoApp.entity.ActivityEventType;

import java.time.LocalDateTime;
import java.util.List;

public class StatisticService {
    public int getCountOfEventByType(List<Activity> activityList, LocalDateTime startTime, LocalDateTime endTime, ActivityEventType activityEventType) {

        return (int) activityList
                .stream()
                .filter(activity ->
                        activity.getActivityEventType() == activityEventType
                                && activity.getTimestamp().isAfter(startTime) &&
                                activity.getTimestamp().isBefore(endTime)).count();
    }
}
