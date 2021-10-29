package dev.naman.splitwise_class.validators;

import org.springframework.stereotype.Service;

@Service
public interface ValidatorInterface {
    boolean validate(String input);
}
