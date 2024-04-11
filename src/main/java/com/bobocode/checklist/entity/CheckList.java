package com.bobocode.checklist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CheckList {
    private Long id;
    private String title;
    private List<Task> tasks;

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task getTask(Long taskId) {
        return tasks.stream()
                .filter(t -> t.getId().equals(taskId))
                .findFirst()
                .orElseThrow();
    }
}
