package dev.naman.splitwise_class.services.console;

import dev.naman.splitwise_class.services.console.exceptions.InvalidInputException;

import java.util.List;

public interface CommandInterface {
    boolean matches(List<String> command);

    void execute(List<String> command) throws InvalidInputException;
}

// check if a particular string is for that command
// for (Command c: commands) {
//   if (c.matches(input)) {
//     c.execute(input);
//   }
// }
// matches: String comparison
