package com.example.geektrust.services.impl;

import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.models.Command;
import com.example.geektrust.models.Course;
import com.example.geektrust.services.CommandExecutor;

public class CancelCourseCommandExecutorImpl implements CommandExecutor{
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) {
        String regId = command.getCommandParams().get(Constants.ZERO);
        if(isValidRegistrationID(regId,registrationIdCourseMap)){
            if(isCourseNotAllotted(regId,registrationIdCourseMap)){
                System.out.println(regId+" "+Constants.CANCEL_REJECTED);
            }else{
                //Remove the registration for the employee...
                removeRegisteredEmployee(regId,registrationIdCourseMap);
                System.out.println(regId+" "+Constants.CANCEL_ACCEPTED);
            }
        }else{
            System.out.println(regId+" "+Constants.CANCEL_REJECTED);
        }
    }

    private void removeRegisteredEmployee(String regId, Map<String, Course> registrationIdCourseMap) {
        Course course = registrationIdCourseMap.get(regId);
        course.getRegisteredEmployees().remove(regId);
        registrationIdCourseMap.remove(regId);
    }

    private boolean isCourseNotAllotted(String regId, Map<String, Course> registrationIdCourseMap) {
        return registrationIdCourseMap.get(regId).isAllotted();
    }

    private boolean isValidRegistrationID(String regId, Map<String, Course> registrationIdCourseMap) {
        if(registrationIdCourseMap.get(regId)!=null){
            return true;
        }else{
            return false;
        }
    }
}
