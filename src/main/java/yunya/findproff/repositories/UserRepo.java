package yunya.findproff.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yunya.findproff.models.User;

public interface UserRepo extends JpaRepository<User, Integer> {
}
