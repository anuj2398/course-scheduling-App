package com.example.geektrust.services;

import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.entities.Command;
import com.example.geektrust.entities.Course;
import com.example.geektrust.exceptions.CourseFullException;
import com.example.geektrust.exceptions.InvalidInputException;

public interface CommandExecutor {
        void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException, CourseFullException;

}
