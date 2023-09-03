package com.example.geektrust.exceptionTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.geektrust.exceptions.CourseFullException;

public class CourseFullExceptionTest {
     @Test
    public void testCourseFullExceptionMessage() {
        String expectedMessage = "The course is already full";
        
        try {
            throw new CourseFullException(expectedMessage);
        } catch (CourseFullException ex) {
            String actualMessage = ex.getMessage();
            assertEquals(expectedMessage, actualMessage);
        }
    }
}
