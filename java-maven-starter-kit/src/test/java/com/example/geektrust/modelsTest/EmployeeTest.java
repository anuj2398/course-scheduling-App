package com.example.geektrust.modelsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.example.geektrust.entities.Employee;
import com.example.geektrust.exceptions.InvalidInputException;

public class EmployeeTest {
    @Test
    public void testValidEmployeeCreation() {
        String validEmailAddress = "john.doe@example.com";

        try {
            Employee employee = new Employee(validEmailAddress);

            assertEquals("john.doe", employee.getName());
            assertEquals(validEmailAddress, employee.getEmailAddress());
        } catch (InvalidInputException e) {
            fail("Exception should not have been thrown for a valid input.");
        }
    }

    @Test
    public void testInvalidEmployeeCreation() {
        String invalidEmailAddress = "invalid-email";

        try {
            Employee employee = new Employee(invalidEmailAddress);
            fail("Exception should have been thrown for an invalid input.");
        } catch (InvalidInputException e) {
            assertEquals("INPUT_DATA_ERROR", e.getMessage());
        }
    }
}
