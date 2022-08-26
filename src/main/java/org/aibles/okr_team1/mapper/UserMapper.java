package org.aibles.okr_team1.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import liquibase.repackaged.org.apache.commons.collections4.CollectionUtils;
import org.aibles.okr_team1.dto.UserDto;
import org.aibles.okr_team1.entity.User;
import org.modelmapper.ModelMapper;

public class UserMapper {
  private final ModelMapper modelMapper;

  public UserMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }


  public UserDto mapToDto(User user) {
    return modelMapper.map(user, UserDto.class);
  }

  public User mapToEntity(UserDto userDto) {

    return  modelMapper.map(userDto, User.class);
  }
  public <T, H> List<T> mapList(List<H> inputData, Class<T> clazz) {
    return CollectionUtils.isEmpty(inputData) ?
        Collections.emptyList() :
        inputData.stream()
            .map(i -> modelMapper.map(i, clazz))
            .collect(Collectors.toList());
  }

}
