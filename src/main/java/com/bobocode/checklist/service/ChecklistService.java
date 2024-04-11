package com.bobocode.checklist.service;

import com.bobocode.checklist.entity.CheckList;
import com.bobocode.checklist.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ChecklistService {

    private final Map<Long, CheckList> taskListByIdMap = new ConcurrentHashMap<>();
    private final AtomicLong listIdGenerator = new AtomicLong(0L);
    private final AtomicLong taskIdGenerator = new AtomicLong(0L);

    public CheckList saveList(CheckList checkList) {
        Long generatedId = listIdGenerator.incrementAndGet();
        checkList.getTasks()
                .forEach(task -> task.setId(taskIdGenerator.incrementAndGet()));
        taskListByIdMap.put(generatedId, checkList);

        return checkList;
    }

    public void addTaskToList(CheckList checkList, Task task) {
        task.setId(taskIdGenerator.incrementAndGet());
        checkList.addTask(task);
    }

    public Task updateTask(Task updatedTask) {
        Long listId = updatedTask.getListId();
        List<Task> tasks = taskListByIdMap.get(listId)
                .getTasks();
        tasks.stream()
                .filter(task -> task.getId().equals(updatedTask.getId()))
                .findAny()
                .ifPresent(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setCompleted(updatedTask.isCompleted());
                });

        return updatedTask;
    }

    public CheckList getListById(Long checkListId) {
        return taskListByIdMap.get(checkListId);
    }
}
