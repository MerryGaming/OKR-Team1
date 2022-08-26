package org.aibles.okr_team1.service.impl;

import com.sun.jdi.InternalException;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aibles.okr_team1.dto.KeyResultsDto;
import org.aibles.okr_team1.entity.KeyResults;
import org.aibles.okr_team1.exception.InternalServerException;
import org.aibles.okr_team1.exception.ResourceNotFoundException;
import org.aibles.okr_team1.repository.KeyResultsRepository;
import org.aibles.okr_team1.service.KeyResultsService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

@Slf4j
public class KeyResultsServiceImpl implements KeyResultsService {
  private final KeyResultsRepository keyResultsRepository;
  private final ModelMapper modelMapper;

  public KeyResultsServiceImpl(KeyResultsRepository keyResultsRepository, ModelMapper modelMapper) {
    this.keyResultsRepository =keyResultsRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public KeyResultsDto created(KeyResultsDto keyResultsDto) {
    log.info("(Create) Create dto");
    KeyResults keyResults = new KeyResults();
    keyResults = modelMapper.mapToEntity(keyResults, keyResultsDto);
    KeyResults create = keyResultsRepository.save(keyResults);
    Optional.ofNullable(create)
        .orElseThrow(
            () -> {
              throw new InternalException("404_Not_Found");
            });
    KeyResultsDto workerDtoCreate = modelMapper.mapToDto(create);
    return workerDtoCreate;
  }

  @Override
  public void delete(long id) {
    log.info("Delete keyresults by id");
    KeyResults keyResults =
        keyResultsRepository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new InternalServerException("404_Not_Found", HttpStatus.NOT_FOUND);
                }
            );
    keyResultsRepository.delete(keyResults);
  }

  @Override
  @Transactional
  public List<KeyResults> list() {
    log.info("List key results");
    List<KeyResults> keyResultsList = keyResultsRepository.findAll();
    return keyResultsList;
  }

  @Override
  public KeyResultsDto update(long id, KeyResultsDto keyResultsDto) {
    log.info("(Update) Update worker by id");
    KeyResults keyResultsCheck =
        keyResultsRepository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new ResourceNotFoundException("Worker not found! ", HttpStatus.NOT_FOUND);
                });
    KeyResults keyResults = new KeyResults();
    keyResults = modelMapper.mapToEntity(keyResults, keyResultsDto);
    keyResults.setId(keyResultsCheck.getId());
    KeyResults update = keyResultsRepository.save(keyResults);
    Optional.of(update)
        .orElseThrow(
            () -> {
              throw new InternalException("Update found, update again!!");
            });
    KeyResultsDto workerDtoUpdated = modelMapper.mapToDto(update);
    return workerDtoUpdated;
  }
}
