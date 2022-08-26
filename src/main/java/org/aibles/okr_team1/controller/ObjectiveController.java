package org.aibles.okr_team1.controller;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.okr_team1.dto.ObjectiveDto;
import org.aibles.okr_team1.entity.Objective;
import org.aibles.okr_team1.service.ObjectiveService;
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
@RequestMapping("/api/v1/objectives")
@Slf4j
public class ObjectiveController {
  private final ObjectiveService objectiveService;

  @Autowired
  public ObjectiveController(ObjectiveService objectiveService) {
    this.objectiveService = objectiveService;
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public String deleteById(@PathVariable("id") long id) {

    objectiveService.delete(id);
    return "Successful delete";
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ObjectiveDto created(@RequestBody @Validated() ObjectiveDto objectiveDto) {
    return objectiveService.created(objectiveDto);
  }


  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Objective> list() {
    return objectiveService.list();
  }



  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public ObjectiveDto update(@PathVariable("id") long id, @RequestBody @Valid ObjectiveDto objectiveDto) {
    return objectiveService.update(id, objectiveDto);
  }
}
