package dev.naman.splitwise_class.services.console;

import dev.naman.splitwise_class.services.console.exceptions.CommandNotValidException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CommandHandlerImpl implements CommandHandlerInterface {
    private List<CommandInterface> commands = new ArrayList<>();

    @Override
    public void execute(String commandString) throws CommandNotValidException {
        boolean matched = false;
        List<String> commandWords = Arrays.asList(commandString.split(" "));
        for (CommandInterface command: commands) {
            if (command.matches(commandWords)) {
                matched = true;
                System.out.println("Executing command");
                command.execute(commandWords);
                break;
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
