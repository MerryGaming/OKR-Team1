package org.aibles.okr_team1.service;

import java.util.List;
import org.aibles.okr_team1.dto.ObjectiveDto;
import org.aibles.okr_team1.entity.Objective;


public interface ObjectiveService {

  ObjectiveDto created(ObjectiveDto objectiveDto);

  void delete(long id);

  List<Objective> list();

  ObjectiveDto update(long id, ObjectiveDto objectiveDto);
}
