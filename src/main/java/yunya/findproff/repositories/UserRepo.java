package yunya.findproff.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yunya.findproff.models.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findById(int id);

    Optional<User> findByUsername(String username);
}
