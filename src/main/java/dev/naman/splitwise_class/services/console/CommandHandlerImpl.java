package dev.naman.splitwise_class.services.console;

import dev.naman.splitwise_class.services.console.exceptions.CommandNotValidException;

import java.util.ArrayList;
import java.util.List;

public class CommandHandlerImpl implements CommandHandlerInterface {
    private List<CommandInterface> commands = new ArrayList<>();

    @Override
    public void execute(String commandString) throws CommandNotValidException {
        boolean matched = false;
        for (CommandInterface command: commands) {
            if (command.matches(commandString)) {
                matched = true;
                command.execute(commandString);
            }
        }

        if (!matched) {
            throw new CommandNotValidException(commandString);
        }
    }

    @Override
    public void registerCommand(CommandInterface command) {
        commands.add(command);
    }
}
