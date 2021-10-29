package dev.naman.splitwise_class.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserResponseDto {
    private String name;
    private String phoneNumber;
    private String email;
    private Long id;
}
