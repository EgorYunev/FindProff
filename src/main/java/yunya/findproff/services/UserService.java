package yunya.findproff.services;

import org.springframework.stereotype.Service;
import yunya.findproff.models.User;
import yunya.findproff.repositories.UserRepo;

@Service
public interface UserService {

    void addUser(User user);

    User getUserById(int id);

    User getUserByUsername(String username);

    void changeUser(User user);

    void deleteUserById(User user);
}
