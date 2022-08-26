package org.aibles.okr_team1.service.impl;


import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aibles.okr_team1.dto.UserDto;
import org.aibles.okr_team1.entity.User;
import org.aibles.okr_team1.exception.InternalServerException;
import org.aibles.okr_team1.exception.ResourceNotFoundException;
import org.aibles.okr_team1.mapper.UserMapper;
import org.aibles.okr_team1.repository.UserRepository;
import org.aibles.okr_team1.service.UserService;
import org.springframework.http.HttpStatus;

@Slf4j
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper modelMapper;

  public UserServiceImpl(UserRepository userRepository, UserMapper modelMapper) {
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
  }


  @Override
  @Transactional
  public UserDto created(UserDto userDto) {
    log.info("(Create) Create dto");
    User user = new User();
    user = modelMapper.mapToEntity(userDto);
    User create = userRepository.save(user);
    Optional.ofNullable(create)
        .orElseThrow(
            () -> {
              throw new InternalServerException("404_Not_Found", HttpStatus.NOT_FOUND);
            });
    UserDto userDtoCreate = modelMapper.mapToDto(create);
    return userDtoCreate;
  }

  @Override
  @Transactional
  public void delete(long id) {
    log.info("Delete user by id");
    User user =
        userRepository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new InternalServerException("404_Not_Found", HttpStatus.NOT_FOUND);
                }
            );
    userRepository.delete(user);
  }

  @Override
  @Transactional
  public List<User> list() {
    log.info("List user");
    List<User> userList = userRepository.findAll();
    return userList;
  }

  @Override
  public UserDto update(long id, UserDto userDto) {
    log.info("(Update) Update user by id");
    User userCheck =
        userRepository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new ResourceNotFoundException("Please update again", HttpStatus.NOT_FOUND);

                });
    User user = new User();
    user = modelMapper.mapToEntity(userDto);
    user.setId(userCheck.getId());
    User update = userRepository.save(user);
    Optional.of(update)
        .orElseThrow(
            () -> {
              throw new InternalServerException("Update found, update again!!",
                  HttpStatus.NOT_FOUND);
            });
    UserDto userDtoUpdated = modelMapper.mapToDto(update);
    return userDtoUpdated;
  }
}
