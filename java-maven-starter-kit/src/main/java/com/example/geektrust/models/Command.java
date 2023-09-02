package com.example.geektrust.models;

import java.util.List;

import com.example.geektrust.enums.CommandOperator;

public class Command {
    private final CommandOperator inputCommand;
    private final List<String> commandParams;

    public Command(CommandOperator inputCommand, List<String> commandParams){
        this.inputCommand = inputCommand;
        this.commandParams = commandParams;
    }

    public CommandOperator getInputCommand() {
        return inputCommand;
    }

    public List<String> getCommandParams() {
        return commandParams;
    }
}
