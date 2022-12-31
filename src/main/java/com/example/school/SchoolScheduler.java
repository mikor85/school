package com.example.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SchoolScheduler {

    @Autowired
    TaskScheduler taskScheduler;

    public void scheduleTask(Date dateTime){
        taskScheduler.schedule(
                this::myTask,
                dateTime
        );
    }

    public void myTask() {
        // задача, которую нужно выполнить

    }
}