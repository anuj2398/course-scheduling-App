package com.example.geektrust.exceptionTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.geektrust.exceptions.InvalidInputException;

public class InvalidInputExceptionTest {
    @Test
    public void testInvalidInputExceptionMessage() {
        String expectedMessage = "Invalid input provided";

        try {
            throw new InvalidInputException(expectedMessage);
        } catch (InvalidInputException ex) {
            String actualMessage = ex.getMessage();
            assertEquals(expectedMessage, actualMessage);
        }
    }
}
