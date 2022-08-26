package org.aibles.okr_team1.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.aibles.okr_team1.dto.KeyResultsDto;
import org.modelmapper.ModelMapper;


@Data
@Table(name = "keyresults")
public class KeyResults {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "deadline")
  private Date deadline;

  @Column(name = "progress")
  private float progress;


  @Column(name = "status")
  private String status;

  @Column(name = "objective_id")
  private Long objective_id;



}
