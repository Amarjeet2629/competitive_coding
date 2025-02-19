package org.cp.LLD.todoApp.entity.impl;

import org.cp.LLD.todoApp.entity.Activity;
import org.cp.LLD.todoApp.entity.ActivityEventType;
import org.cp.LLD.todoApp.entity.Task;

public class CompletionEvent extends Activity {
    public CompletionEvent(String id, Task task) {
        super(id, task, ActivityEventType.COMPLETION);
    }

    @Override
    public String toString() {
        return getTask().getName() + " was completed on " + getTask().getCompletionDate() + ".";
    }
}
