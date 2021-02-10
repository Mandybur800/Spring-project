package org.test.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.dto.UserResponseDto;
import org.test.model.User;
import org.test.service.UserMapper;
import org.test.service.UserMapperImpl;
import org.test.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    @Autowired
    UserController(UserService userService, UserMapperImpl mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/{userId}")
    public UserResponseDto getUser(@PathVariable(name = "userId") Long userId) {
        return mapper.mapUserToDto(userService.get(userId));
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.listUsers()
                .stream()
                .map(mapper::mapUserToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/inject")
    public String injectUsers() {
        User bob = new User("Bob", "Bobolino", "bob_bob@bob.bcom");
        userService.add(bob);
        User alice = new User("Alice", "Alisson", "alice@ali.ce");
        userService.add(alice);
        User kate = new User("Kate", "Katon", "kate@ka.te");
        userService.add(kate);
        User john = new User("John", "Johnson", "john@jo.jo");
        userService.add(john);
        return "4 users was added";
    }
}
