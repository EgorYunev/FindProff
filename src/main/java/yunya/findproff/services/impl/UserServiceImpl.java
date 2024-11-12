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
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email is busy");
        } else if (userRepo.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username is busy");
        } else {
            userRepo.save(user);
        }
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
    public void deleteUserById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> op = userRepo.findByEmail(email);
        if (op.isPresent()) {
            return op.get();
        } else {
            throw new RuntimeException("user cannot found " + email);
        }
    }
}
