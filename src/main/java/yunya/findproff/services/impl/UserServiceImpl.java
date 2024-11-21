package yunya.findproff.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yunya.findproff.models.User;
import yunya.findproff.repositories.UserRepo;
import yunya.findproff.services.UserService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

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
        System.out.println(op.isPresent());
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
