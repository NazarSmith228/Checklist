package com.bobocode.checklist.controller;

import com.bobocode.checklist.entity.CheckList;
import com.bobocode.checklist.entity.Task;
import com.bobocode.checklist.service.ChecklistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/api/checklist")
@RequiredArgsConstructor
public class CheckListController {

    private final ChecklistService checklistService;

    @PostMapping("/")
    public String createChecklist(@RequestBody CheckList checkList, Model model) {
        CheckList saved = checklistService.saveList(checkList);
        model.addAttribute(saved);
        return "index";
    }

    @PostMapping("/{checklist_id}/task")
    public String addTask(@PathVariable("checklist_id") Long checklistId, @RequestBody Task task,
                          Model model) {
        CheckList checkList = checklistService.getListById(checklistId);
        checklistService.addTaskToList(checkList, task);
        model.addAttribute(checkList);
        return "index";
    }

    @PostMapping("/{checklist_id}/task/{task_id}")
    public String toggleTask(@PathVariable("checklist_id") Long checklistId,
                             @PathVariable("task_id") Long taskId,
                             Model model) {
        CheckList checkList = checklistService.getListById(checklistId);
        Task task = checkList.getTask(taskId);
        task.setCompleted(true);
        model.addAttribute(checkList);
        return "index";
    }

}
