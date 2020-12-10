package org.example.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 @Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchStatsDeleteDto {
    private String mid;
    private int pid;
}

