package com.example.geektrust.modelsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.example.geektrust.entities.Course;
import com.example.geektrust.entities.Employee;
import com.example.geektrust.exceptions.InvalidInputException;

public class CourseTest {
    //@Test
    // public void testAddEmployee() throws InvalidInputException {
    //     // Create a sample Course
    //     Course course = new Course("C001", "Java Programming", "Instructor1", new Date(), 10, 20, false, false);

    //     // Create a sample Employee
    //     Employee employee = new Employee("John");

    //     // Add the Employee to the Course
    //     String registrationID = course.addEmployee(employee);

    //     // Check if the Employee was added successfully
    //     assertNotNull(registrationID);
    //     assertTrue(course.getRegisteredEmployees().containsKey(registrationID));
    //     assertEquals(employee, course.getRegisteredEmployees().get(registrationID));
    // }

    @Test
    public void testCompareTo() {
        Course course1 = new Course("C001", "Java Programming", "Instructor1", new Date(), 10, 20, false, false);
        Course course2 = new Course("C002", "Python Programming", "Instructor2", new Date(), 15, 25, false, false);
        Course course3 = new Course("C003", "C++ Programming", "Instructor3", new Date(), 12, 22, false, false);

        // Ensure compareTo compares courses by course name
        assertTrue(course1.compareTo(course2) < 0);
        assertTrue(course2.compareTo(course1) > 0);
        assertEquals(0, course1.compareTo(course1));
        assertTrue(course1.compareTo(course3) > 0);
    }
}
