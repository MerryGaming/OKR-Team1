package org.aibles.okr_team1.service;

import java.util.List;
import org.aibles.okr_team1.dto.UserDto;
import org.aibles.okr_team1.entity.User;

public interface UserService {

  UserDto created(UserDto userDto);

  void delete(long id);

  List<User> list();

  UserDto update(long id, UserDto userDto);
}
