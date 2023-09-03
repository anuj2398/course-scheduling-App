package com.example.geektrust.modelsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.geektrust.enums.CommandOperator;
import com.example.geektrust.models.Command;

public class CommandTest {
     @Test
    public void testGetInputCommand() {
        CommandOperator expectedCommand = CommandOperator.ADD_COURSE_OFFERING;
        List<String> commandParams = Arrays.asList("param1", "param2");
        
        Command command = new Command(expectedCommand, commandParams);
        CommandOperator actualCommand = command.getInputCommand();
        
        assertEquals(expectedCommand, actualCommand);
    }

    @Test
    public void testGetCommandParams() {
        CommandOperator command = CommandOperator.ADD_COURSE_OFFERING;
        List<String> expectedParams = Arrays.asList("param1", "param2");
        
        Command inputCommand = new Command(command, expectedParams);
        List<String> actualParams = inputCommand.getCommandParams();
        
        assertIterableEquals(expectedParams, actualParams);
    }
}
