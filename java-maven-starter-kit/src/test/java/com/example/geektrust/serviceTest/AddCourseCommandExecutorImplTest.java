package com.example.geektrust.serviceTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.concetes.CommandExecutionFactory;
import com.example.geektrust.entities.Command;
import com.example.geektrust.entities.Course;
import com.example.geektrust.exceptions.CourseFullException;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.services.CommandExecutor;
import com.example.geektrust.services.CommandService;


public class AddCourseCommandExecutorImplTest {
     Command command1;
    CommandExecutor executor;
    private  TreeMap<String , Course> courses;
    private  Map<String,Course> registrationIdCourseMap;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws InvalidInputException {
        System.setOut(new PrintStream(outContent));
        command1 = CommandService.getInstance().getCommandFromString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        executor = CommandExecutionFactory.getExecutor(command1);
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }

    @Test
    public void testExecute(){
        assertDoesNotThrow( ()->executor.executeCommand(courses , registrationIdCourseMap , command1));
    }


    @Test
    public void testSuccessMessage() throws InvalidInputException, CourseFullException {
        executor.executeCommand(courses , registrationIdCourseMap , command1);
        assertEquals("OFFERING-JAVA-JAMES",outContent.toString().trim());
    }
}
