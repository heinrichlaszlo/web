package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.controller.dto.Match_StatsDto;
import org.example.service.Match_StatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MatchStatsController {

    private final Match_StatsService service;

    @GetMapping("/MatchStats")
    public Collection<Match_StatsDto>  listMatchStats(){
        return service.getAllMatchStats()
        .stream()
        .map(model ->Match_StatsDto.builder()
              .loc(model.getLoc())
              .ki(model.getKi())
              .mk(model.getMk())
              .mb(model.getMb())
              .di(model.getDi())
              .gl(model.getGl())
              .bh(model.getBh())
              .ho(model.getHo())
                .tk(model.getTk())
                .rb(model.getRb())
                .lf(model.getLf())
                .cl(model.getCl())
                .cg(model.getCg())
                .ff(model.getFf())
                .fa(model.getFa())
                .br(model.getBr())
                .cp(model.getCp())
                .up(model.getUp())
                .cm(model.getCm())
                .mi(model.getMi())
                .lp(model.getLp())
                .bo(model.getBo())
                .ga(model.getGa())
                .pp(model.getPp())
              .build())
        .collect(Collectors.toList()) ;
    }
}
