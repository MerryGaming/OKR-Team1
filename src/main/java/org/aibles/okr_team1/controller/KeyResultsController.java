package org.aibles.okr_team1.controller;


import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.okr_team1.dto.KeyResultsDto;
import org.aibles.okr_team1.entity.KeyResults;
import org.aibles.okr_team1.repository.KeyResultsRepository;
import org.aibles.okr_team1.service.KeyResultsService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/keyresults")
@Slf4j
public class KeyResultsController {
  private final KeyResultsService keyResultsService;

  @Autowired
  public KeyResultsController(KeyResultsService keyResultsService) {
    this.keyResultsService = keyResultsService;
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public String deleteById(@PathVariable("id") long id) {

    keyResultsService.delete(id);
    return "Successful delete";
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public KeyResultsDto created(@RequestBody @Validated() KeyResultsDto keyResultsDto) {
    return keyResultsService.created(keyResultsDto);
  }


  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<KeyResults> list() {
    return keyResultsService.list();
  }



  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public KeyResultsDto update(@PathVariable("id") long id, @RequestBody @Valid KeyResultsDto keyResultsDto) {
    return keyResultsService.update(id, keyResultsDto);
  }
}
