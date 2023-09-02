package com.example.geektrust.services.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.models.Command;
import com.example.geektrust.models.Course;
import com.example.geektrust.services.CommandExecutor;

public class AddCourseCommandExecutorImpl implements CommandExecutor {

    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException {
        List<String> params = command.getCommandParams();
        Course course = constructCourseObject(params);
        offerCourse(courses , course);
    }

    private Course constructCourseObject(List<String> params) throws InvalidInputException {
        Course course = null;
        try{
            String courseName = params.get(Constants.ZERO);
            String courseInstructor = params.get(Constants.ONE);
            SimpleDateFormat inputFormat = new SimpleDateFormat("ddMMyyyy");
            Date d = inputFormat.parse(params.get(Constants.TWO));
            int minCount = Integer.parseInt(params.get(Constants.THREE));
            int maxCount = Integer.parseInt(params.get(Constants.FOUR));
            course = new Course("OFFERING-"+courseName+"-"+courseInstructor,courseName , courseInstructor , d ,minCount , maxCount , false, false);
        }catch (Exception e){
            throw new InvalidInputException("INPUT_ERROR");
        }
        return course;
    }

    private void offerCourse(TreeMap<String, Course> courses, Course course){
        courses.put(course.getCourseID(),course);
        System.out.println(course.getCourseID());
    }

}