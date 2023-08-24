package com.docme.docmeapi.mapper;


import com.docme.docmeapi.dto.UserDto;
import com.docme.docmeapi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDTOToUser (UserDto userDto);
    UserDto userToUserDTO(User user);


}
