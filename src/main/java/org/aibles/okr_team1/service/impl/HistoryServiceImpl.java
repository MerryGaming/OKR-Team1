package org.aibles.okr_team1.service.impl;

import com.sun.jdi.InternalException;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aibles.okr_team1.dto.HistoryDto;
import org.aibles.okr_team1.entity.History;
import org.aibles.okr_team1.exception.InternalServerException;
import org.aibles.okr_team1.exception.ResourceNotFoundException;
import org.aibles.okr_team1.repository.HistorysRepository;
import org.aibles.okr_team1.service.HistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

@Slf4j
public class HistoryServiceImpl implements HistoryService {

  private final HistorysRepository historysRepository;
  private final ModelMapper modelMapper;

  public HistoryServiceImpl(HistorysRepository historysRepository, ModelMapper modelMapper) {
    this.historysRepository = historysRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public HistoryDto created(HistoryDto historyDto) {
    log.info("(Create) Create dto");
    History history = new History();
    history = modelMapper.mapToEntity(history, historyDto);
    History create = historysRepository.save(history);
    Optional.ofNullable(create)
        .orElseThrow(
            () -> {
              throw new InternalException("404_Not_Found");
            });
    HistoryDto workerDtoCreate = modelMapper.mapToDto(create);
    return workerDtoCreate;
  }

  @Override
  public void delete(long id) {
    log.info("Delete history by id");
    History history =
        historysRepository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new InternalServerException("404_Not_Found", HttpStatus.NOT_FOUND);
                }
            );
    historysRepository.delete(history);
  }

  @Override
  @Transactional
  public List<History> list() {
    log.info("List history");
    List<History> historyList = historysRepository.findAll();
    return historyList;
  }

  @Override
  public HistoryDto update(long id, HistoryDto historyDto) {
    log.info("(Update) Update worker by id");
    History historyCheck =
        historysRepository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new ResourceNotFoundException("Worker not found! ", HttpStatus.NOT_FOUND);
                });
    History history = new History();
    history = modelMapper.mapToEntity(history, historyDto);
    history.setId(historyCheck.getId());
    History update = historysRepository.save(history);
    Optional.of(update)
        .orElseThrow(
            () -> {
              throw new InternalException("Update found, update again!!");
            });
    HistoryDto workerDtoUpdated = modelMapper.mapToDto(update);
    return workerDtoUpdated;
  }
}
