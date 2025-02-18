package org.cp.LLD.todoApp.entity.impl;

import org.cp.LLD.todoApp.entity.Activity;
import org.cp.LLD.todoApp.entity.ActivityEventType;
import org.cp.LLD.todoApp.entity.Task;

public class AdditionEvent extends Activity {
    public AdditionEvent(String id, Task task) {
        super(id, task, ActivityEventType.ADDITION);
    }

    @Override
    public String toString() {
        return getTask().getName() + " was added on " + getTask().getCreatedDate() + ".";
    }
}
