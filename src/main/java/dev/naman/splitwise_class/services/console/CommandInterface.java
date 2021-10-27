package dev.naman.splitwise_class.services.console;

public interface CommandInterface {
    boolean matches(String command);

    void execute(String command);
}

// check if a particular string is for that command
// for (Command c: commands) {
//   if (c.matches(input)) {
//     c.execute(input);
//   }
// }
// matches: String comparison
