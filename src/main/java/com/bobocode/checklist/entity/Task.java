package com.bobocode.checklist.entity;

import lombok.Data;

@Data
public class Task {
    private Long id;
    private String title;
    private boolean isCompleted;
}
