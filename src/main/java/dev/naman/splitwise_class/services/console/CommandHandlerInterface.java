package dev.naman.splitwise_class.services.console;

import dev.naman.splitwise_class.services.console.exceptions.CommandNotValidException;

public interface CommandHandlerInterface {
    void execute(String command) throws CommandNotValidException;
    void registerCommand(CommandInterface command);
}


/// someone will register m,ultiple commands to it
// tell it to execute a command
// COmmandHandler
// - regioster a user
// add an expense
// add a group

// Assignment
// Implement atleast 3 commands in the requirements