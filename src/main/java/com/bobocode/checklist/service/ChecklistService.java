package com.bobocode.checklist.service;

import com.bobocode.checklist.entity.CheckList;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChecklistService {

    private final Map<Long, CheckList> taskListByIdMap = new ConcurrentHashMap<>();
}
