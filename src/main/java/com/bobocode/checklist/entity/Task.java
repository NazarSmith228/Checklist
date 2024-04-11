package com.bobocode.checklist.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Task {
    private Long id;
    private String title;
    private boolean isCompleted;
}
