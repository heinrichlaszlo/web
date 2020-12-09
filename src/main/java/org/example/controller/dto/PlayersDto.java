package org.example.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayersDto {

    private String first_name;
    private String last_name;
    private int height;
    private int weight;
}
