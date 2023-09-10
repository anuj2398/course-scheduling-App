package com.example.geektrust.services.impl;

import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.entities.Command;
import com.example.geektrust.entities.Course;
import com.example.geektrust.entities.Employee;
import com.example.geektrust.exceptions.CourseFullException;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.services.CommandExecutor;

public class RegisterCourseCommandExecutorImpl implements CommandExecutor{
     @Override
     public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException, CourseFullException {
        String courseID = command.getCommandParams().get(Constants.ONE);
        Employee employee = ConstructEmployeeObject(command);
    
        if (!courses.containsKey(courseID)) {
            // In case of course ID is not present in the course offering list.
            System.out.println("INPUT_DATA_ERROR");
            return;
        }
    
        Course course = courses.get(courseID);
    
        if (course.isAllotted() || course.isCancelled()) {
            // In case the course is allotted or cancelled already.
            System.out.println("REG-COURSE-" + employee.getName() + "-" + course.getCourseName() + " " + Constants.REJECTED);
        } else if (course.getRegisteredEmployees().size() == course.getMaxCapacity()) {
            // The course is full.
            throw new CourseFullException("COURSE_FULL_ERROR");
        } else {
            // Register the employee to the course.
            registerEmployeeToCourse(employee, course, registrationIdCourseMap);
        }
    }
    

    private void registerEmployeeToCourse(Employee employee, Course course, Map<String, Course> registrationIdCourseMap) {
        String regID = course.addEmployee(employee);
        registrationIdCourseMap.put(regID , course);
        System.out.println(regID+" "+Constants.ACCEPTED);
    }

    private Employee ConstructEmployeeObject(Command command) throws InvalidInputException {
        return new Employee(command.getCommandParams().get(0));
    }
}
