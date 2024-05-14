package com.project.springboot.project_tracker.utility.mapper;

import com.project.springboot.project_tracker.dto.user_dto.UserDto;
import com.project.springboot.project_tracker.model.users.User;
import jakarta.persistence.Entity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UserDto userDto, @MappingTarget User user);

}
