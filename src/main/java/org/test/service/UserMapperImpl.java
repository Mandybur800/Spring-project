package org.test.service;

import org.springframework.stereotype.Component;
import org.test.dto.UserResponseDto;
import org.test.model.User;

@Component
public class UserMapperImpl implements UserMapper {
    public UserResponseDto mapUserToDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getMail());
        return dto;
    }
}
