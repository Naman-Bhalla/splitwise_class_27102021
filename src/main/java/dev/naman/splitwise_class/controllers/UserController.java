package dev.naman.splitwise_class.controllers;

import dev.naman.splitwise_class.dtos.RegisterUserRequestDto;
import dev.naman.splitwise_class.dtos.RegisterUserResponseDto;
import dev.naman.splitwise_class.models.User;
import dev.naman.splitwise_class.services.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RegisterUserResponseDto register(RegisterUserRequestDto request) {
        User user = userService.register(request.getName(),
                request.getPhoneNumber(), request.getEmail(), request.getPassword());

        RegisterUserResponseDto responseDto = new RegisterUserResponseDto();
        responseDto.setEmail(user.getEmail());
        responseDto.setPhoneNumber(user.getPhoneNumber());
        responseDto.setName(user.getName());
        responseDto.setId(user.getId());
        return responseDto;
    }

}

// only if we are passing multiple parameters
// OR in future number of parameters can change
// P1 -> rajma chawal -> waiter goes to chef and asks it to prepare it
// P@ -> rajm,ma chawal + ice cream -> waiter will go to chef 1 for rajma chawal and p2 for ice cream