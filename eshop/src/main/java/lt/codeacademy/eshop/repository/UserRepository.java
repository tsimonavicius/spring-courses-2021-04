package lt.codeacademy.eshop.repository;

import lt.codeacademy.eshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByName(String name);
}
