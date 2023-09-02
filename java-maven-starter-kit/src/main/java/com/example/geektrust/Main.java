package com.example.geektrust;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.example.geektrust.concetes.LearningManagementSystem;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.models.Command;
import com.example.geektrust.services.FileProcesserService;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new FileNotFoundException("Input file is not supplied");
            } else {
                LearningManagementSystem lms = new LearningManagementSystem("Intuit");
                FileProcesserService fileProcesserService = new FileProcesserService(args[0]);
                try {
                    try {
                        Command command = fileProcesserService.processLine();
                        while (command != null) {
                            lms.fulfillCommand(command);
                            command = fileProcesserService.processLine();
                        }
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
