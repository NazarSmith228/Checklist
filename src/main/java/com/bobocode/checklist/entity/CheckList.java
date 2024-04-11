package com.bobocode.checklist.entity;

import lombok.Data;

import java.util.List;

@Data
public class CheckList {
    private Long id;
    private List<Task> tasks;
}
