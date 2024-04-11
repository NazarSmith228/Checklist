package com.bobocode.checklist.controller;

import com.bobocode.checklist.entity.Task;
import com.bobocode.checklist.service.ChecklistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CheckListController {

    private final ChecklistService checklistService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", checklistService.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String name) {
        checklistService.add(new Task(name, false));
        return "redirect:/";
    }

    @PostMapping("/toggle")
    public String toggleTask(@RequestParam Long id) {
//        Task task = checklistService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));
//        task.setCompleted(!task.getCompleted());
//        taskRepository.save(task);
        return "redirect:/";
    }
}
