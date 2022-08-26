package org.aibles.okr_team1.controller;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.okr_team1.dto.HistoryDto;
import org.aibles.okr_team1.entity.History;
import org.aibles.okr_team1.service.HistoryService;
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
@RequestMapping("/api/v1/historys")
@Slf4j
public class HistoryController {
  private final HistoryService historyService;

  @Autowired
  public HistoryController(HistoryService historyService) {
    this.historyService = historyService;
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public String deleteById(@PathVariable("id") long id) {

    historyService.delete(id);
    return "Successful delete";
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public HistoryDto created(@RequestBody @Validated() HistoryDto historyDto) {
    return historyService.created(historyDto);
  }


  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<History> list() {
    return historyService.list();
  }



  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public HistoryDto update(@PathVariable("id") long id, @RequestBody @Valid HistoryDto historyDto) {
    return historyService.update(id, historyDto);
  }
}
