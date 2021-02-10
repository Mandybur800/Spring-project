package org.test.service;

import org.test.dto.UserResponseDto;
import org.test.model.User;

public interface UserMapper {
    UserResponseDto mapUserToDto(User user);
}
