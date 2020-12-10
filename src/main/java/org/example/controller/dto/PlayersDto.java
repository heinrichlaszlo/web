package org.example.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayersDto {
    private int id;
    private String dob;
    private String first_name;
    private String last_name;
    private int height;
    private int weight;
}
