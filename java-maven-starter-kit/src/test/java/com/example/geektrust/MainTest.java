package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.concetes.LearningManagementSystem;
import com.example.geektrust.services.FileProcesserService;

public class MainTest {
     private Main app;

    @BeforeEach
    public void setUp() {
        app = new Main();
    }

    @Test
    public void testRun_ValidArguments() {
        // Redirect standard error stream to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outContent));

        // Run the 'run' method with valid arguments
        app.run(new String[]{"sample_input/input1"});

        // Restore the standard error stream
        System.setErr(System.err);

        // Check if usage message is not printed
        assertFalse(outContent.toString().contains("Usage:"));
    }
}