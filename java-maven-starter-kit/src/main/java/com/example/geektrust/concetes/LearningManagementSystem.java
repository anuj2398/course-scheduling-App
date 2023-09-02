package com.example.geektrust.concetes;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.exceptions.CourseFullException;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.models.Command;
import com.example.geektrust.models.Course;
import com.example.geektrust.services.CommandExecutor;

public class LearningManagementSystem {
    private final String organisationName;
    private final TreeMap<String , Course> courses;
    private final Map<String,Course> registrationIdCourseMap;

    public LearningManagementSystem(String name) {
        this.organisationName = name;
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }

    public void fulfillCommand(Command inputCommand) throws InvalidInputException {
        CommandExecutor commandExecutor = CommandExecutionFactory.getExecutor(inputCommand);
        try{
            commandExecutor.executeCommand(courses,registrationIdCourseMap, inputCommand);
        }catch(CourseFullException e ){
            System.out.println(e.getMessage());
        }
    }
}
