package org.test.service;

import org.test.dto.UserResponseDto;
import org.test.model.User;

public interface UserMapper {
    User mapUserFromDto(UserResponseDto dto);

    UserResponseDto mapUserToDto(User user);
}
