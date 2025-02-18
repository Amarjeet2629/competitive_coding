package org.cp.LLD.todoApp.entity.impl;

import org.cp.LLD.todoApp.entity.Activity;
import org.cp.LLD.todoApp.entity.ActivityEventType;
import org.cp.LLD.todoApp.entity.Task;

public class ModificationEvent extends Activity {
    public ModificationEvent(String id, Task task) {
        super(id, task, ActivityEventType.MODIFICATION);
    }

    @Override
    public String toString() {
        return getTask().getName() + " was modified.";
    }
}
