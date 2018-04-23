package br.gov.mg.meioambiente.simge.controller.mapper;


import org.mapstruct.Mapper;

import br.gov.mg.meioambiente.simge.controller.dto.UserDto;
import br.gov.mg.meioambiente.simge.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto map(User user);

    List<UserDto> map(List<User> users);
}