package dev.naman.splitwise_class.validators;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UsernameValidator {
    public boolean validate(String input) {
        return input.length() > 2;
    }
}
