package org.cp.LLD.todoApp.service;


import org.cp.LLD.todoApp.entity.ActivityEventType;
import org.cp.LLD.todoApp.entity.Task;
import org.cp.LLD.todoApp.entity.TaskStatus;
import org.cp.LLD.todoApp.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

public class TodoApp {
  UserService userService;
  ActivityManager activityManager;
  StatisticService statisticService;
  TaskService taskService;

  public TodoApp(UserService userService, ActivityManager activityManager, StatisticService statisticService, TaskService taskService){
      this.activityManager = activityManager;
      this.statisticService = statisticService;
      this.userService = userService;
      this.taskService = taskService;
  }

  public void addTask(String name, int ownerUserId, LocalDateTime creationDate, LocalDateTime dueDate, String description){
      User user = userService.getUserById(ownerUserId);
      Task task = new Task(taskService.getTaskCount() + 1, name, description, dueDate, creationDate, user);

      taskService.addTask(task);
      user.addTask(task);
      activityManager.addNewActivity(ActivityEventType.ADDITION, task);
  }

  public Task getTask(int taskId){
      return taskService.getTaskById(taskId);
  }

  public void updateTask(int taskId, LocalDateTime dueDate, String description, String name){
      Task task = taskService.getTaskById(taskId);
      task.setDescription(description);
      task.setDueDate(dueDate);
      task.setName(name);

      taskService.modifyTask(task);
      activityManager.addNewActivity(ActivityEventType.MODIFICATION, task);
  }

  public void updateTaskStatus(int taskId, TaskStatus taskStatus){
      Task task = taskService.getTaskById(taskId);
      if(taskStatus == TaskStatus.COMPLETED){
          task.setStatus(taskStatus);

          taskService.modifyTask(task);
          activityManager.addNewActivity(ActivityEventType.COMPLETION, task);
      } else {
          task.setStatus(taskStatus);

          taskService.modifyTask(task);
          activityManager.addNewActivity(ActivityEventType.MODIFICATION, task);
      }
  }

  public void removeTask(int taskId){
      Task task = taskService.getTaskById(taskId);
      taskService.removeTask(taskId);

      //remove from user
      User user = userService.getUserById(task.getOwnerUser().getId());
      user.removeTask(task);

      activityManager.addNewActivity(ActivityEventType.REMOVAL, task);
  }

  public List<Task> getAllTaskByFilter(List<Predicate<Task>> filters){
      return taskService.getAllTaskByFilter(filters).stream().filter(task -> task.getStatus() != TaskStatus.COMPLETED).toList();
  }

  public int getCountByEvent(ActivityEventType activityEventType, LocalDateTime startTime, LocalDateTime endTime){
      return statisticService.getCountOfEventByType(activityManager.getActivityListInRange(startTime, endTime), startTime, endTime, activityEventType);
  }
}
