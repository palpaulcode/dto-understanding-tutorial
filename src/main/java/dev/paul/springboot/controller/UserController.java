package dev.paul.springboot.controller;

import dev.paul.springboot.dto.UserLocationDTO;
import dev.paul.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users-location")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserLocationDTO> getAllUsersLocation() {
        return userService.getAllUsersLocation();
    }

    @GetMapping("/{userId}")
    public UserLocationDTO getUserLocationByUserId(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }
}
