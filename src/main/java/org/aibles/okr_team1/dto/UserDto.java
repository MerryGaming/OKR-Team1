package org.aibles.okr_team1.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import org.aibles.okr_team1.entity.User;
import org.modelmapper.ModelMapper;

@Data
public class UserDto {

  private final ModelMapper modelMapper;
  @NotBlank
  @Size(min = 2, max = 128)
  private String email;

  @NotBlank
  @Size(min = 2, max = 128)
  private String password;

  @NotBlank
  @Size(min = 2, max = 128)
  private String firstname;

  @NotBlank
  @Size(min = 2, max = 128)
  private String lastname;

  @NotBlank
  @Size(min = 2, max = 128)
  private String number_phone;


  private Date date_of_birth;

  @NotBlank
  @Size(min = 2, max = 256)
  private String address;


}
