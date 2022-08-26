package org.aibles.okr_team1.controller;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.okr_team1.dto.UserDto;
import org.aibles.okr_team1.entity.User;
import org.aibles.okr_team1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public String deleteById(@PathVariable("id") long id) {
    userService.delete(id);
    return "Successful delete";
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UserDto created(@RequestBody @Validated() UserDto userDto) {
    return userService.created(userDto);
  }


  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<User> list() {
    return userService.list();
  }



  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public UserDto update(@PathVariable("id") long id, @RequestBody @Valid UserDto userDto) {
    return userService.update(id, userDto);
  }
}
