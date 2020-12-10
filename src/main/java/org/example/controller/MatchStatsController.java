package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.controller.dto.MatchStatsDeleteDto;
import org.example.controller.dto.Match_StatsDto;
import org.example.exception.UnknownMatchStatsException;
import org.example.model.MatchStats;
import org.example.service.Match_StatsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping("/matchStats")
    public void recordMatchStats(@RequestBody Match_StatsDto matchStatsDto){
        try {
            service.recordMatchStats(new MatchStats(

                    matchStatsDto.getLoc(),
                    matchStatsDto.getKi(),
                    matchStatsDto.getMk(),
                    matchStatsDto.getBh(),
                    matchStatsDto.getDi(),
                    matchStatsDto.getGl(),
                    matchStatsDto.getBh(),
                    matchStatsDto.getHo(),
                    matchStatsDto.getTk(),
                    matchStatsDto.getRb(),
                    matchStatsDto.getLf(),
                    matchStatsDto.getCl(),
                    matchStatsDto.getCg(),
                    matchStatsDto.getFf(),
                    matchStatsDto.getFa(),
                    matchStatsDto.getBr(),
                    matchStatsDto.getCp(),
                    matchStatsDto.getUp(),
                    matchStatsDto.getCm(),
                    matchStatsDto.getMi(),
                    matchStatsDto.getLp(),
                    matchStatsDto.getBo(),
                    matchStatsDto.getGa(),
                    matchStatsDto.getPp()
            ));
        } catch (UnknownMatchStatsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/matchStats/update")
    public void updateMatchStat(@RequestBody Match_StatsDto matchStatsDto){
        try {
            service.updateMatchStat(new MatchStats(

                    matchStatsDto.getLoc(),
                    matchStatsDto.getKi(),
                    matchStatsDto.getMk(),
                    matchStatsDto.getBh(),
                    matchStatsDto.getDi(),
                    matchStatsDto.getGl(),
                    matchStatsDto.getBh(),
                    matchStatsDto.getHo(),
                    matchStatsDto.getTk(),
                    matchStatsDto.getRb(),
                    matchStatsDto.getLf(),
                    matchStatsDto.getCl(),
                    matchStatsDto.getCg(),
                    matchStatsDto.getFf(),
                    matchStatsDto.getFa(),
                    matchStatsDto.getBr(),
                    matchStatsDto.getCp(),
                    matchStatsDto.getUp(),
                    matchStatsDto.getCm(),
                    matchStatsDto.getMi(),
                    matchStatsDto.getLp(),
                    matchStatsDto.getBo(),
                    matchStatsDto.getGa(),
                    matchStatsDto.getPp()
            ));
        } catch (UnknownMatchStatsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/matchStats")
    public void deleteMatchStats(@RequestBody MatchStatsDeleteDto matchStatsDto){
        try {
            service.deleteMatchStat(matchStatsDto.getMid(),matchStatsDto.getPid());
        } catch (UnknownMatchStatsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
