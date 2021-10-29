package dev.naman.splitwise_class.services.console;

import dev.naman.splitwise_class.controllers.UserController;
import dev.naman.splitwise_class.dtos.RegisterUserRequestDto;
import dev.naman.splitwise_class.dtos.RegisterUserResponseDto;
import dev.naman.splitwise_class.repositories.UserRepository;
import dev.naman.splitwise_class.services.console.exceptions.InvalidInputException;
import dev.naman.splitwise_class.validators.UsernameValidator;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class RegisterUserCommand implements CommandInterface {
    private UsernameValidator usernameValidator;
    private UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController, UsernameValidator usernameValidator) {
        this.userController = userController;
        this.usernameValidator = usernameValidator;
    }

    @Override
    public boolean matches(List<String> command) {
        System.out.println("In register user command");
        return command.size() == 4 && command.get(0).equals("Register");
    }

    @Override
    public void execute(List<String> command) {
        String username = command.get(1);
        String phoneNumber = command.get(2);
        String password = command.get(3);

        if (!usernameValidator.validate(username)) {
            throw new InvalidInputException(username, command.toString());
        }

        RegisterUserRequestDto dto = new RegisterUserRequestDto();
        dto.setName(username);
        dto.setPassword(password);
        dto.setPhoneNumber(phoneNumber);
        RegisterUserResponseDto responseDto = userController.register(dto);
        System.out.println(responseDto.getId());
        // if I perform actions like
        // interacting with db
        // doing validations etc
    }
}


// Register vinsmokesanji 003 namisswwaann
//  {"Register", "vinsmokesanji", "003", "namisswwaann"}

// "Register vinsmokesanji 003 namisswwaann"[:8] == "Register"
// O(n)

// UpdateProfile u1 robinchwan
// command handler: Map<String, CommandINterface>
// for every command:
// map[command.split()[0].execute()]

// MVC architecture
// Controller -> providesw an interface to interact with (waiter)
// Service -> perform the actions (chef)
// Repository -> DB: interact with the data (fridge/ kitchen/ store)

// console will interact with controller
// controller will interact with service
// service will interact with a repository

// Machine COding: 30 mins of discussions
// + 1 hrs of implementation
// 30 mins of discussions

//  1. Start with the boilerplate
// Create all the packages: controlller, services, repositories
// Create services (Only implement 1)
// Go and implement the runner
// start creating srvices 1 by 1