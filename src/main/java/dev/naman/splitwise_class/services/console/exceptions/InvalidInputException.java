package dev.naman.splitwise_class.services.console.exceptions;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String input, String command) {
        super(input + " in " + command + " is invalid.");
    }
}
