package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String text) {
        tasks.add(text);
    }

    public List<String> getTaskList() {
        return new ArrayList<>(tasks);
    }
}
