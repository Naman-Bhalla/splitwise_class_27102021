package dev.naman.splitwise_class.services.console;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommandRegistrar {
    private RegisterUserCommand registerUserCommand;
    private CommandHandlerInterface commandHandler;

    public void execute() {
        commandHandler.registerCommand(registerUserCommand);
    }
}
