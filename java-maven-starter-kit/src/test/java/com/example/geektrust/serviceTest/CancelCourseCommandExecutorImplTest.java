package com.example.geektrust.serviceTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.concetes.CommandExecutionFactory;
import com.example.geektrust.exceptions.CourseFullException;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.models.Command;
import com.example.geektrust.models.Course;
import com.example.geektrust.services.CommandExecutor;
import com.example.geektrust.services.CommandService;


public class CancelCourseCommandExecutorImplTest {
    
    Command command1;
    Command command2;
    Command command3;
    CommandExecutor executor1;
    CommandExecutor executor2;
    CommandExecutor executor3;

    private TreeMap<String , Course> courses;
    private Map<String,Course> registrationIdCourseMap;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws InvalidInputException, CourseFullException {
        System.setOut(new PrintStream(outContent));
        command1 = CommandService.getInstance().getCommandFromString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        command2 = CommandService.getInstance().getCommandFromString("REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES");
        command3 = CommandService.getInstance().getCommandFromString("CANCEL REG-COURSE-ANDY-JAVA");
        executor1 = CommandExecutionFactory.getExecutor(command1);
        executor2 = CommandExecutionFactory.getExecutor(command2);
        executor3 = CommandExecutionFactory.getExecutor(command3);
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
        executor1.executeCommand(courses , registrationIdCourseMap , command1);
        executor2.executeCommand(courses,registrationIdCourseMap , command2);

    }

    @Test
    public void testExecute() {
        assertDoesNotThrow(()->executor3.executeCommand(courses , registrationIdCourseMap , command3));
    }

}
