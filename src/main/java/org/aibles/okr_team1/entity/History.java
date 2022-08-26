package org.aibles.okr_team1.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.aibles.okr_team1.dto.HistoryDto;
import org.aibles.okr_team1.dto.UserDto;
import org.modelmapper.ModelMapper;

@Data
@Table(name = "history")
public class History {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "messenger")
  private String messenger;

  @Column(name = "progress")
  private Float progress;

  @Column(name = "commit")
  private String commit;

  @Column(name = "keyresults_id")
  private Long keyresults_id;

}
