package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.controller.dto.MatchesDeleteDto;
import org.example.controller.dto.MatchesDto;
import org.example.controller.dto.MatchesRequestDto;
import org.example.exception.UnknownMatchesException;
import org.example.exception.UnknownTeamsException;
import org.example.model.Matches;
import org.example.service.MatchesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MatchesController {
    private final MatchesService service;



    @GetMapping("/matches")
    public Collection<MatchesDto> listMatches(){
        return service.getAllMatches()
                .stream()
                .map(model -> MatchesDto.builder()
                        .id(model.getId())
                        .season(model.getSeason())
                        .round(model.getRound())
                        .tid1(model.getTid1())
                        .tid2(model.getTid2())
                        .tid1_loc(model.getTid1_loc())
                        .tid2_loc(model.getTid2_loc())
                        .start_dt(model.getStart_dt())
                        .venue(model.getVenue())
                        .att(model.getAtt())
                        .margin(model.getMargin())
                        .win_score(model.getWin_score())
                        .win_tid(model.getWin_tid())
                        .win_loc(model.getWin_loc())
                        .lose_score(model.getLose_score())
                        .lose_loc(model.getLose_loc())
                        .lose_tid(model.getLose_tid())
                        .h_tid(model.getH_tid())
                        .h_score(model.getH_score())
                        .h_q1g(model.getH_q1g())
                        .h_q2g(model.getH_q2g())
                        .h_q3g(model.getH_q3g())
                        .h_q4g(model.getH_q4g())
                        .h_etg(model.getH_etg())
                        .h_q1b(model.getH_q1b())
                        .h_q2b(model.getH_q2b())
                        .h_q3b(model.getH_q3b())
                        .h_q4b(model.getH_q4b())
                        .a_tid(model.getA_tid())
                        .a_score(model.getA_score())
                        .a_q1g(model.getA_q1g())
                        .a_q2g(model.getA_q2g())
                        .a_q3g(model.getA_q3g())
                        .a_q4g(model.getA_q4g())
                        .a_etg(model.getA_etg())
                        .a_q1b(model.getA_q1b())
                        .a_q2b(model.getA_q2b())
                        .a_q3b(model.getA_q3b())
                        .a_q4b(model.getA_q4b())
                        .a_etb(model.getA_etb())
                        .target(model.getTarget())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/matches/record")
    public void record(@RequestBody MatchesRequestDto requestDto) {
        try {
            service.recordMatch(new Matches(
                    requestDto.getSeason()+"_"+requestDto.getRound()+"_"+requestDto.getTid1()+"_"+requestDto.getTid2(),
                    requestDto.getSeason(),
                    requestDto.getRound(),
                    requestDto.getTid1(),
                    requestDto.getTid2(),
                    requestDto.getTid1_loc(),
                    requestDto.getTid2_loc(),
                    Timestamp.valueOf(requestDto.getStart_dt()),
                    requestDto.getVenue(),
                    requestDto.getAtt(),
                    requestDto.getMargin(),
                    requestDto.getWin_score(),
                    requestDto.getWin_tid(),
                    requestDto.getWin_loc(),
                    requestDto.getLose_score(),
                    requestDto.getLose_loc(),
                    requestDto.getLose_tid(),
                    requestDto.getH_tid(),
                    requestDto.getH_score(),
                    requestDto.getH_q1g(),
                    requestDto.getH_q2g(),
                    requestDto.getH_q3g(),
                    requestDto.getH_q4g(),
                    requestDto.getH_etg(),
                    requestDto.getH_q1b(),
                    requestDto.getH_q2b(),
                    requestDto.getH_q3b(),
                    requestDto.getH_q4b(),
                    requestDto.getH_etb(),
                    requestDto.getA_tid(),
                    requestDto.getA_score(),
                    requestDto.getA_q1g(),
                    requestDto.getA_q2g(),
                    requestDto.getA_q3g(),
                    requestDto.getA_q4g(),
                    requestDto.getA_etg(),
                    requestDto.getA_q1b(),
                    requestDto.getA_q2b(),
                    requestDto.getA_q3b(),
                    requestDto.getA_q4b(),
                    requestDto.getA_etb(),
                    requestDto.getTarget()
            ));
        } catch (UnknownTeamsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/matches/update")
    public void updateMatch(@RequestBody MatchesRequestDto requestDto){
        try {
            service.updateMatch(new Matches(
                    requestDto.getSeason()+"_"+requestDto.getRound()+"_"+requestDto.getTid1()+"_"+requestDto.getTid2(),
                    requestDto.getSeason(),
                    requestDto.getRound(),
                    requestDto.getTid1(),
                    requestDto.getTid2(),
                    requestDto.getTid1_loc(),
                    requestDto.getTid2_loc(),
                    Timestamp.valueOf(requestDto.getStart_dt()),
                    requestDto.getVenue(),
                    requestDto.getAtt(),
                    requestDto.getMargin(),
                    requestDto.getWin_score(),
                    requestDto.getWin_tid(),
                    requestDto.getWin_loc(),
                    requestDto.getLose_score(),
                    requestDto.getLose_loc(),
                    requestDto.getLose_tid(),
                    requestDto.getH_tid(),
                    requestDto.getH_score(),
                    requestDto.getH_q1g(),
                    requestDto.getH_q2g(),
                    requestDto.getH_q3g(),
                    requestDto.getH_q4g(),
                    requestDto.getH_etg(),
                    requestDto.getH_q1b(),
                    requestDto.getH_q2b(),
                    requestDto.getH_q3b(),
                    requestDto.getH_q4b(),
                    requestDto.getH_etb(),
                    requestDto.getA_tid(),
                    requestDto.getA_score(),
                    requestDto.getA_q1g(),
                    requestDto.getA_q2g(),
                    requestDto.getA_q3g(),
                    requestDto.getA_q4g(),
                    requestDto.getA_etg(),
                    requestDto.getA_q1b(),
                    requestDto.getA_q2b(),
                    requestDto.getA_q3b(),
                    requestDto.getA_q4b(),
                    requestDto.getA_etb(),
                    requestDto.getTarget()
            ));
        } catch (UnknownMatchesException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/matches/delete")
    public void deleteMatch(@RequestBody MatchesDeleteDto matchesDto){
        try{
            service.deleteMatch(matchesDto.getId());
        } catch(UnknownMatchesException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}