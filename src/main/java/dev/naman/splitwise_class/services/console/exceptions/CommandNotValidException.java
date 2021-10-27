package dev.naman.splitwise_class.services.console.exceptions;

public class CommandNotValidException extends RuntimeException {
    public CommandNotValidException(String command) {
        super(command + " didn't match any registered commands");
    }
}
