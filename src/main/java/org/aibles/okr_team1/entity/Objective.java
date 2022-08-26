package org.aibles.okr_team1.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.aibles.okr_team1.dto.ObjectiveDto;
import org.modelmapper.ModelMapper;


@Data
@Table(name = "objective")
public class Objective {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private String type;

  @Column(name = "description")
  private String description;

  @Column(name = "deadline")
  private Date deadline;

  @Column(name = "progress")
  private float progress;

  @Column(name = "user_id")
  private Long user_id;


}
