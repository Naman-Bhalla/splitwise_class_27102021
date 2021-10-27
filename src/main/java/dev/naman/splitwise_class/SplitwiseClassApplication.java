package dev.naman.splitwise_class;

import dev.naman.splitwise_class.models.Auditable;
import dev.naman.splitwise_class.services.console.CommandHandlerImpl;
import dev.naman.splitwise_class.services.console.CommandHandlerInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SplitwiseClassApplication {

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseClassApplication.class, args);
        CommandHandlerInterface commandHandler = new CommandHandlerImpl();
        commandHandler.execute("blah blah blah");
        // register command A
        // register COmmand B
        // register COmmand C - in the execute method: just say doing the work

        while (true) {
            // read string
            // commandHandler.execute(string);
        }

    }

}
