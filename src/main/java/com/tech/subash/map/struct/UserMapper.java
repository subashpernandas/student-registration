package com.tech.subash.map.struct;

import com.tech.subash.dto.UserDto;
import com.tech.subash.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mappings({
            @Mapping(source = "userName", target = "name"),
            @Mapping(source = "userEmail", target = "email")})
    UserDto convertFromUserEntity(UserEntity user);

    @Mappings({
            @Mapping(source = "name", target = "userName"),
            @Mapping(source = "email", target = "userEmail")})
    UserEntity convertFromUserDto(UserDto userDto);
}
