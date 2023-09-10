package com.example.geektrust.concetes;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.entities.Command;
import com.example.geektrust.services.CommandExecutor;
import com.example.geektrust.services.impl.AddCourseCommandExecutorImpl;
import com.example.geektrust.services.impl.AllotCourseCommandExecutorImpl;
import com.example.geektrust.services.impl.CancelCourseCommandExecutorImpl;
import com.example.geektrust.services.impl.RegisterCourseCommandExecutorImpl;

public class CommandExecutionFactory {
    public static CommandExecutor getExecutor(Command task) {
        CommandExecutor executor = null;
        if(task!=null){
            switch(task.getInputCommand()){
                case ADD_COURSE_OFFERING:
                    executor = new AddCourseCommandExecutorImpl();
                    break;
                case CANCEL:
                    executor = new CancelCourseCommandExecutorImpl();
                    break;
                case ALLOT:
                    executor = new AllotCourseCommandExecutorImpl();
                    break;
                case REGISTER:
                    executor = new RegisterCourseCommandExecutorImpl();
                    break;
                default:
                    break;
            }
        }
        return executor;
    }
}
