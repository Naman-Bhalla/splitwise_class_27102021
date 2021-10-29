package dev.naman.splitwise_class;

import dev.naman.splitwise_class.models.Auditable;
import dev.naman.splitwise_class.services.console.CommandHandlerImpl;
import dev.naman.splitwise_class.services.console.CommandHandlerInterface;
import dev.naman.splitwise_class.services.console.CommandInterface;
import dev.naman.splitwise_class.services.console.RegisterUserCommand;
import dev.naman.splitwise_class.services.console.exceptions.CommandNotValidException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("dev.naman.splitwise_class")
public class SplitwiseClassApplication {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        SpringApplication.run(SplitwiseClassApplication.class, args);
        CommandHandlerInterface commandHandler = new CommandHandlerImpl();
        // register command A
        CommandInterface c1 = new RegisterUserCommand();
        commandHandler.registerCommand(c1);

        while (true) {
            try {
                System.out.printf("> ");
                String command = br.readLine().toString();
                commandHandler.execute(command);
            } catch (CommandNotValidException exception) {
                System.out.println(exception.getMessage());
            } catch (Exception e) {
                System.out.println("Some input error happened");
            }
        }

    }

}

// Register User  vinsmokesanji 003 namisswwaann