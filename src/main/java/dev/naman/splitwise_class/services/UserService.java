package dev.naman.splitwise_class.services;

import dev.naman.splitwise_class.models.User;
import dev.naman.splitwise_class.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String name, String phoneNumber, String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setName(name);
        user.setPasswordHash(password);
        return userRepository.save(user);
    }
}

// recursive resolver
// INSERT INTO users (username, phoneNumber, email)
// ORM Benefits:
// - Optimized Queries
// - Protects against common attacks - SQL injection
// - Type checking