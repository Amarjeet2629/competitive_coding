package org.cp.LLD.todoApp.entity;

import java.time.LocalDateTime;

public class Task {
    int id;
    String name;
    String description;
    LocalDateTime dueDate;
    LocalDateTime createdDate;
    LocalDateTime completionDate;
    TaskStatus status;
    User ownerUser;

    public Task(int id, String name, String description, LocalDateTime dueDate, LocalDateTime createdDate, User ownerUser) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.createdDate = createdDate;
        this.ownerUser = ownerUser;
        this.status = TaskStatus.TODO;
        this.completionDate = null;
    }

    public Task getCopy(){
        Task task = new Task(this.id, this.name, this.description, this.dueDate, this.createdDate, this.ownerUser);
        task.completionDate = this.completionDate;
        task.status = this.status;

        return task;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = completionDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public User getOwnerUser() {
        return ownerUser;
    }

    @Override
    public String toString() {
        return "Task{ " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", createdDate=" + createdDate +
                ", completionDate=" + completionDate +
                ", status=" + status +
                ", ownerUser=" + ownerUser.getName() +
                '}';
    }
}
