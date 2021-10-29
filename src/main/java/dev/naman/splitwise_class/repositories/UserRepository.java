package dev.naman.splitwise_class.repositories;

import dev.naman.splitwise_class.controllers.UserController;
import dev.naman.splitwise_class.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User entity);

    User findByEmailAndPhoneNumberAndName(String email, String phoneNumber, String name);
}

// Repository<TypeOfId, TypeOfObject>
// UserRepository implements Repository<Long, User>

/// RepositoryInterface<TypeOfEntity, TypeOfId> (interface)
///      extended by UserRepositoryInterface<User, Long> (interface)
///             implemented by SQLUserRepository, MongoDBUserRepository