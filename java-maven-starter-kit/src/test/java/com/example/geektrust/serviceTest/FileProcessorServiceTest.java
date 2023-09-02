package com.example.geektrust.serviceTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.models.Command;
import com.example.geektrust.services.FileProcesserService;

public class FileProcessorServiceTest {
     FileProcesserService service;

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        service = new FileProcesserService("sample_input\\input1.txt");
    }

    @Test
    public void FileProcesserServiceTest() {
        assertThrows(FileNotFoundException.class, () -> new FileProcesserService("abcd"));
    }

    // @Test
    // public void processLineTest() throws InvalidInputException, IOException {
    //     Command c = service.processLine();
    //     Assertions.assertNotNull(c);
    // }

}
