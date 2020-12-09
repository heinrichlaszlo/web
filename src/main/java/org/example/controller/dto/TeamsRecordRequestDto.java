package org.example.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor

public class TeamsRecordRequestDto extends TeamsDto {

 String name;
}
