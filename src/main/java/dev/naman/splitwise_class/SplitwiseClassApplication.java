package dev.naman.splitwise_class;

import dev.naman.splitwise_class.controllers.UserController;
import dev.naman.splitwise_class.models.Auditable;
import dev.naman.splitwise_class.services.console.*;
import dev.naman.splitwise_class.services.console.exceptions.CommandNotValidException;
import org.jboss.jandex.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseClassApplication implements CommandLineRunner {
    private CommandRegistrar commandRegistrar;
    private CommandHandlerInterface commandHandler;
    public SplitwiseClassApplication(CommandHandlerInterface commandHandler, CommandRegistrar commandRegistrar) {
        this.commandRegistrar = commandRegistrar;
        this.commandHandler = commandHandler;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseClassApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        commandRegistrar.execute();

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

// when we run main
// spring creates an object of SpringApplicationContext() set()
// recursively starts going tghrough every dependency
// create an object of each of those and stores it in the context
// starts running the program
// Map{ClassName, object}
