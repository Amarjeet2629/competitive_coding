package org.cp.LLD.todoApp.entity.impl;

import org.cp.LLD.todoApp.entity.Activity;
import org.cp.LLD.todoApp.entity.ActivityEventType;
import org.cp.LLD.todoApp.entity.Task;

public class RemovalEvent extends Activity {
    public RemovalEvent(String id, Task task) {
        super(id, task, ActivityEventType.REMOVAL);
    }

    @Override
    public String toString() {
        return getTask().getName() + " was deleted.";
    }
}
