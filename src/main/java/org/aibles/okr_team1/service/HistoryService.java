package org.aibles.okr_team1.service;

import java.util.List;
import org.aibles.okr_team1.dto.HistoryDto;
import org.aibles.okr_team1.entity.History;


public interface HistoryService {
  HistoryDto created(HistoryDto historyDto);

  void delete(long id);

  List<History> list();

  HistoryDto update(long id, HistoryDto historyDto);

}
