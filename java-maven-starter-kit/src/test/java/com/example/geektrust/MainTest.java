package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.services.FileProcesserService;

public class MainTest {
    // private Main app;
    // private FileProcesserService fileProcessorService;

    // @BeforeEach
    // public void setUp() {
    //     app = new Main();
    //     fileProcessorService = mock(FileProcesserService.class);
    // }

    // @Test
    // public void testPrintUsage() {
    //     ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    //     System.setErr(new PrintStream(outContent));

    //     app.printUsage();

    //     String expectedOutput = "Usage: java CourseSchedulingApp <input-file>\n";
    //     assertEquals(expectedOutput, outContent.toString());
    // }

    // @Test
    // public void testHandleException() {
    //     ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    //     System.setErr(new PrintStream(errContent));

    //     Exception testException = new Exception("Test exception");
    //     app.handleException(testException);

    //     assertTrue(errContent.toString().contains("Error: Test exception"));
    // }

    // You can add more tests for other methods if necessary
}