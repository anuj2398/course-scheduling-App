package com.example.geektrust.services.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.models.Command;
import com.example.geektrust.models.Course;
import com.example.geektrust.models.Employee;
import com.example.geektrust.services.CommandExecutor;

public class AllotCourseCommandExecutorImpl implements CommandExecutor{
     @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException {
        String courseId = command.getCommandParams().get(Constants.ZERO);
        Course course = courses.get(courseId);
        if(course!=null){
            if(course.getRegisteredEmployees().size()<course.getMinCapacity()){
                course.setCancelled(true);
                printCourseData(course);
            }else{
                course.setAllotted(true);
                printCourseData(course);
            }
        }else{
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }

    private void printCourseData(Course course) {
        String status = course.isCancelled()?"COURSE_CANCELED":"CONFIRMED";
        for(Map.Entry<String,Employee> e: course.getRegisteredEmployees().entrySet()){
            String pattern = "ddMMyyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            System.out.println(e.getKey()+" "+e.getValue().getEmailAddress()+" "+course.getCourseID()+" "+course.getCourseName()+" "+course.getInstructor()+" "
                   + df.format(course.getDate())+" "+status);
        }
    }
}
