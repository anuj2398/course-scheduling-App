package com.example.geektrust;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.example.geektrust.concetes.LearningManagementSystem;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.models.Command;
import com.example.geektrust.services.FileProcesserService;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        app.run(args);
    }

    private void run(String[] args) {
        if (args.length != 1) {
            printUsage();
            return;
        }

        try {
            LearningManagementSystem lms = new LearningManagementSystem(null);
            processCommandsFromFile(args[0], lms);
        } catch (IOException | InvalidInputException ex) {
            handleException(ex);
        }
    }

    private void printUsage() {
        System.err.println("Usage: java CourseSchedulingApp <input-file>");
    }

    private LearningManagementSystem initializeLMS() {
        return new LearningManagementSystem("Intuit");
    }

    private void processCommandsFromFile(String inputFileName, LearningManagementSystem lms)
            throws IOException, InvalidInputException {
        FileProcesserService fileProcessorService = new FileProcesserService(inputFileName);
        Command command;
        while ((command = fileProcessorService.processLine()) != null) {
            lms.fulfillCommand(command);
        }
    }

    private void handleException(Exception ex) {
        System.err.println("Error: " + ex.getMessage());
        ex.printStackTrace();
    }
}

