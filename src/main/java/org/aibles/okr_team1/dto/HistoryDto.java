package org.aibles.okr_team1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import org.aibles.okr_team1.entity.History;
import org.modelmapper.ModelMapper;

@Data
public class HistoryDto {

  private final ModelMapper modelMapper;
  @NotBlank
  @Size(min = 2, max = 500)
  private String messenger;

  private Float progress;

  @NotBlank
  @Size(min = 2, max = 500)
  private String commit;

  private Long keyresults_id;
}
