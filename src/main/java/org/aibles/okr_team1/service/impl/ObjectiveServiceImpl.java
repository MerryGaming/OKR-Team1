package org.aibles.okr_team1.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aibles.okr_team1.dto.ObjectiveDto;
import org.aibles.okr_team1.entity.Objective;
import org.aibles.okr_team1.exception.InternalServerException;
import org.aibles.okr_team1.exception.ResourceNotFoundException;
import org.aibles.okr_team1.repository.ObjectiveRepository;
import org.aibles.okr_team1.service.ObjectiveService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

@Slf4j
public class ObjectiveServiceImpl implements ObjectiveService {
  private final ObjectiveRepository objectiveRepository;
  private final ModelMapper modelMapper;

  public ObjectiveServiceImpl(ObjectiveRepository objectiveRepository, ModelMapper modelMapper) {
    this.objectiveRepository = objectiveRepository;
    this.modelMapper = modelMapper;
  }


  @Override
  @Transactional
  public ObjectiveDto created(ObjectiveDto objectiveDto) {
    log.info("(Create) Create objective");
    Objective objective = new Objective();
    objective  = modelMapper.mapToEntity(objectiveDto);
    Objective create = objectiveRepository.save(objective );
    Optional.ofNullable(create)
        .orElseThrow(
            () -> {
              throw new InternalServerException("404_Not_Found", HttpStatus.NOT_FOUND);
            });
    ObjectiveDto objectiveDtoCreate = modelMapper.mapToDto(create);
    return objectiveDtoCreate;
  }

  @Override
  @Transactional
  public void delete(long id) {
    log.info("Delete objective by id");
    Objective objective =
        objectiveRepository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new InternalServerException("404_Not_Found", HttpStatus.NOT_FOUND);
                }
            );
    objectiveRepository.delete(objective);
  }

  @Override
  @Transactional
  public List<Objective> list() {
    log.info("List objective");
    List<Objective> objectiveList = objectiveRepository.findAll();
    return objectiveList;
  }

  @Override
  public ObjectiveDto update(long id, ObjectiveDto objectiveDto) {
    log.info("(Update) Update objective by id");
    Objective objectiveCheck =
        objectiveRepository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new ResourceNotFoundException("Please update again", HttpStatus.NOT_FOUND);

                });
    Objective objective = new Objective();
    objective = modelMapper.mapToEntity(objectiveDto);
    objective.setId(objectiveCheck.getId());
    Objective update = objectiveRepository.save(objective);
    Optional.of(update)
        .orElseThrow(
            () -> {
              throw new InternalServerException("Update found, update again!!", HttpStatus.NOT_FOUND);
            });
    ObjectiveDto objectiveDtoUpdated = modelMapper.mapToDto(update);
    return objectiveDtoUpdated;
  }
}
