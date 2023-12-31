package com.example.geektrust.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.entities.Command;
import com.example.geektrust.enums.CommandOperator;
import com.example.geektrust.exceptions.InvalidInputException;

public class CommandService {
    static CommandService commandService = null;

    public static CommandService getInstance(){
        if(commandService==null){
            commandService = new CommandService();
        }
        return commandService;
    }

    public Command getCommandFromString(String input) throws InvalidInputException {
        try {
            String[] commandWithArguments = input.split(" ");
            CommandOperator operator = CommandOperator.valueOf(Constants.getValue(commandWithArguments[Constants.ZERO]));
            List<String> commandParams =
                    Arrays.stream(commandWithArguments).skip(Constants.ONE).collect(Collectors.toList());
            Command command = new Command(operator, commandParams);
            this.validateInputCommand(operator,command);
            return command;
        } catch (Exception e) {
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }

    private void validateInputCommand(CommandOperator inputCommand , Command command) throws InvalidInputException {
        if(inputCommand.getNumberOfArguments()!=command.getCommandParams().size()){
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }
}
