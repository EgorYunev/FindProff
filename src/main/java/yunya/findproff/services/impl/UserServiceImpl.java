package yunya.findproff.services.impl;

import org.springframework.stereotype.Service;
import yunya.findproff.models.User;
import yunya.findproff.repositories.UserRepo;
import yunya.findproff.services.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    private final UserRepo userRepo;

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User getUserById(int id) {
        Optional<User> op = userRepo.findById(id);
        return op.orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> op = userRepo.findByUsername(username);
        return op.orElse(null);
    }

    @Override
    public void changeUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUserById(User user) {
        userRepo.delete(user);
    }
}
