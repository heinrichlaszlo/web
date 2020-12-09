package org.example.controller;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.controller.dto.*;
import org.example.exception.UnknownTeamsException;
import org.example.model.Teams;
import org.example.service.TeamsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;




@Slf4j
@RestController
@RequiredArgsConstructor
public class TeamsController {

    private final TeamsService service;


    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "World", required = false) String name) {
        return String.format("Hello %s!", name);

    }

    @ApiOperation("Say Hello")
    @GetMapping("/hello/{name}")
    public String helloPath(@PathVariable("name") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/teams")
    public Collection<TeamsDto> listteams() {
        return service.getAllTeams()
                .stream()
                .map(model -> TeamsDto.builder()
                        .name(model.getName())
                        .build())
                .collect(Collectors.toList());

    }

    @PostMapping("/teams")
    public void record(@RequestBody TeamsRecordRequestDto requestDto)  {
        try {


            service.recordTeams(new Teams(
                    requestDto.getName()
            ));
        } catch (UnknownTeamsException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/teams/request")
    public void RequestTeams(@RequestBody TeamsRequestDto requestDto){
        try{
            service.updateTeams(new Teams(
                    requestDto.getName()
            ));
        }catch (UnknownTeamsException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @DeleteMapping("/teams/delete")
    public void deleteTeams(@RequestBody TeamsDeleteDto teamsDto){
        try{
            service.deleteTeams(teamsDto.getName());

        }catch(UnknownTeamsException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
