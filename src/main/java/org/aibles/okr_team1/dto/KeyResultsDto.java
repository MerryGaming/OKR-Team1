package org.aibles.okr_team1.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import org.aibles.okr_team1.entity.KeyResults;
import org.modelmapper.ModelMapper;


@Data
public class KeyResultsDto {

  private final ModelMapper modelMapper;
  @NotBlank
  @Size(min = 2, max = 128)
  private String name;

  @NotBlank
  @Size(min = 2, max = 500)
  private String description;

  private Date deadline;

  @NotBlank
  @Size(min = 2, max = 500)
  private String progress;

  @NotBlank
  @Size(min = 2, max = 128)
  private String status;

  private Long user_objective;


}
