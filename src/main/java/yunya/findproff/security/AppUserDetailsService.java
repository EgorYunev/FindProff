package yunya.findproff.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yunya.findproff.models.User;
import yunya.findproff.repositories.UserRepo;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repo.findUserByUsername(username);
        return user.map(AppUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
