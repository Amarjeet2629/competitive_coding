package org.cp.LLD.todoApp;

import org.cp.LLD.todoApp.entity.ActivityEventType;
import org.cp.LLD.todoApp.entity.Task;
import org.cp.LLD.todoApp.entity.TaskStatus;
import org.cp.LLD.todoApp.entity.User;
import org.cp.LLD.todoApp.service.*;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String ...args){
        //Create User
        UserService userService = new UserService();
        TaskService taskService = new TaskService();
        StatisticService statisticService = new StatisticService();
        ActivityManager activityManager = new ActivityManager();

        userService.addUser(new User(1, "Amarjeet"));
        userService.addUser(new User(2, "Arpita"));
        userService.addUser(new User(3, "Prachi"));

        TodoApp todoApp = new TodoApp(userService, activityManager, statisticService, taskService);

        //add Task
        todoApp.addTask("Task 1", 1,
                LocalDateTime.now(), LocalDateTime.of(2025, 02, 19, 0, 0),
                "This is very first task"
                );

        todoApp.addTask("Task 2", 2,
                LocalDateTime.now(), LocalDateTime.of(2025, 02, 19, 0, 0),
                "This is very second task"
        );

        todoApp.addTask("Task 3", 3,
                LocalDateTime.now(), LocalDateTime.of(2025, 02, 19, 0, 0),
                "This is very third task"
        );


        List<Task> tasks = todoApp.getAllTaskByFilter(null);

        for(Task task: tasks){
            System.out.println(task);
        }

        System.out.println("Tasks added in duration: " + todoApp.getCountByEvent(ActivityEventType.ADDITION,
                LocalDateTime.of(2025, 02, 17, 0, 0),
                LocalDateTime.of(2025, 02, 19, 0, 0)));

        Task task = todoApp.getTask(1);

        todoApp.updateTask(1, task.getDueDate(), "This is modified task", task.getName());
        todoApp.updateTaskStatus(1, TaskStatus.IN_PROGRESS);

        System.out.println("Tasks modified in duration: " + todoApp.getCountByEvent(ActivityEventType.MODIFICATION,
                LocalDateTime.of(2025, 02, 17, 0, 0),
                LocalDateTime.of(2025, 02, 19, 0, 0)));


        for(Task itrTask: todoApp.getAllTaskByFilter(null)){
            System.out.println(itrTask);
        }

        todoApp.updateTaskStatus(1, TaskStatus.COMPLETED);

        System.out.println("Tasks completed in duration: " + todoApp.getCountByEvent(ActivityEventType.COMPLETION,
                LocalDateTime.of(2025, 02, 17, 0, 0),
                LocalDateTime.of(2025, 02, 19, 0, 0)));


        for(Task itrTask: todoApp.getAllTaskByFilter(null)){
            System.out.println(itrTask);
        }

    }
}
