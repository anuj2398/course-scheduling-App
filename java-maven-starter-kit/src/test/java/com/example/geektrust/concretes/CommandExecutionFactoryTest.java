package com.example.geektrust.concretes;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.geektrust.concetes.CommandExecutionFactory;
import com.example.geektrust.entities.Command;
import com.example.geektrust.enums.CommandOperator;
import com.example.geektrust.services.CommandExecutor;
import com.example.geektrust.services.impl.AddCourseCommandExecutorImpl;
import com.example.geektrust.services.impl.AllotCourseCommandExecutorImpl;
import com.example.geektrust.services.impl.CancelCourseCommandExecutorImpl;
import com.example.geektrust.services.impl.RegisterCourseCommandExecutorImpl;

public class CommandExecutionFactoryTest {
    @Test
    public void testGetExecutor_AddCourse() {
        CommandExecutor executor = CommandExecutionFactory.getExecutor(new Command(CommandOperator.ADD_COURSE_OFFERING, null));
        assertTrue(executor instanceof AddCourseCommandExecutorImpl);
    }

    @Test
    public void testGetExecutor_CancelCourse() {
        CommandExecutor executor = CommandExecutionFactory.getExecutor(new Command(CommandOperator.CANCEL, null));
        assertTrue(executor instanceof CancelCourseCommandExecutorImpl);
    }

    @Test
    public void testGetExecutor_AllotCourse() {
        CommandExecutor executor = CommandExecutionFactory.getExecutor(new Command(CommandOperator.ALLOT, null));
        assertTrue(executor instanceof AllotCourseCommandExecutorImpl);
    }

    @Test
    public void testGetExecutor_RegisterCourse() {
        CommandExecutor executor = CommandExecutionFactory.getExecutor(new Command(CommandOperator.REGISTER, null));
        assertTrue(executor instanceof RegisterCourseCommandExecutorImpl);
    }

    @Test
    public void testGetExecutor_NullCommand() {
        CommandExecutor executor = CommandExecutionFactory.getExecutor(null);
        assertNull(executor);
    }

}
