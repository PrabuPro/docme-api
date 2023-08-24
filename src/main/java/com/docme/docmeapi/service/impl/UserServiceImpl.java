package com.docme.docmeapi.service.impl;

import com.docme.docmeapi.dto.UserDto;
import com.docme.docmeapi.mapper.UserMapper;
import com.docme.docmeapi.model.Role;
import com.docme.docmeapi.model.RoleType;
import com.docme.docmeapi.model.User;
import com.docme.docmeapi.repository.UserRepository;
import com.docme.docmeapi.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final UserMapper userMapper;
    private final UserRepository userRepository;


//  TODO - check email exist in database
//         api call the keycloak and get keycloak Id
    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = userMapper.userDTOToUser(userDto);

        Role userRole = Role.builder()
                .roleType(RoleType.USER)
                .build();

        List<Role> userRoles = Arrays.asList(userRole);
        user.setRole(userRoles);

        User savedUser = userRepository.save(user);

        return userMapper.userToUserDTO(savedUser);
    }
}
