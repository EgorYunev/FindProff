package yunya.findproff.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yunya.findproff.DTO.UserDTO;
import yunya.findproff.models.User;
import yunya.findproff.services.UserService;

import java.security.Principal;
import java.util.ArrayList;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/save")
    public String saveUser(@ModelAttribute UserDTO dto) {
        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .roles("USER")
                .requests(new ArrayList<>())
                .reviews(new ArrayList<>())
                .build();
        userService.addUser(user);
        return "success";

    }

    @GetMapping("/get-by-username/{username}")
    public String getUserByUsername(@RequestAttribute String username, Model model) {
        model.addAttribute(userService.getUserByUsername(username));
        return "user";
    }

    @PostMapping("/change")
    public String changeUser(@ModelAttribute UserDTO dto, Principal principal) {
        int id = userService.getUserByUsername(principal.getName()).getId();
        User changedUser = User.builder()
                .email(dto.getEmail())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .id(id)
                .build();
        userService.changeUser(changedUser);
        return "success";
    }

    @PostMapping("/delete")
    public String deleteUser(Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        userService.deleteUserById(user.getId());
        return "success";
    }

}