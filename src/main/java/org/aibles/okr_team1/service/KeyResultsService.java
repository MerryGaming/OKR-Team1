package org.aibles.okr_team1.service;

import java.util.List;
import org.aibles.okr_team1.dto.KeyResultsDto;
import org.aibles.okr_team1.entity.KeyResults;

public interface KeyResultsService {

  KeyResultsDto created(KeyResultsDto keyResultsDto);

  void delete(long id);

  List<KeyResults> list();

  KeyResultsDto update(long id, KeyResultsDto keyResultsDto);
}
