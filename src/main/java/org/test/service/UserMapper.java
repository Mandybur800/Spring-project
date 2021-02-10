package org.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.dto.UserResponseDto;
import org.test.model.User;

@Component
public class UserMapper {
    private final UserService userService;

    @Autowired
    public UserMapper(UserService userService) {
        this.userService = userService;
    }

    public UserResponseDto mapUserToDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setName(user.getFirstName() + " " + user.getLastName());
        dto.setEmail(user.getMail());
        return dto;
    }

    public User mapUserFromDto(UserResponseDto dto) {
        User user = new User();
        String[] strings = dto.getName().split(" ");
        if (strings.length == 1) {
            user.setFirstName(strings[0]);
        } else if (strings.length != 0) {
            user.setFirstName(strings[0]);
            user.setLastName(strings[strings.length - 1]);
        }
        user.setMail(dto.getEmail());
        userService.add(user);
        return user;
    }
}
