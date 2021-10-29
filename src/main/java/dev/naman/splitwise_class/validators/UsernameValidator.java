package dev.naman.splitwise_class.validators;

import org.springframework.stereotype.Service;

@Service
public class UsernameValidator {
    public boolean validate(String input) {
        return input.length() > 2;
    }
}
