package dev.naman.splitwise_class.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    private String phoneNumber;
    private String email;
    private String name;
    private String password;
}
