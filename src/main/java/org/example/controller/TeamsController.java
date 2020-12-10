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

    @GetMapping("/teams/list1")
    public Collection<TeamsDto> listteams() {
        return service.getAllTeams()
                .stream()
                .map(model -> TeamsDto.builder()
                        .name(model.getName())
                        .build())
                .collect(Collectors.toList());

    }

 @GetMapping("/teams/list")
    public Collection<TeamsDto> listTeams(){
        return service.getAllTeams().stream()
                .map(model -> new TeamsDto(
                        model.getId(),
                        model.getName()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping("/teams")
    public void recordTeams(@RequestBody TeamsDto teamsDto){
        try {
            service.recordTeams(new Teams(
                    teamsDto.getId(),
                    teamsDto.getName()
            ));
        } catch (UnknownTeamsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/teams/update")
    public void updateTeam(@RequestBody TeamsDto teamsDto){
        try {
            service.updateTeams(new Teams(
                    teamsDto.getId(),
                    teamsDto.getName()
            ));
        } catch (UnknownTeamsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/teams/delete")
    public void deleteTeams(@RequestBody TeamsDeleteDto teamsDeleteDto){
        try {
            service.deleteTeams(teamsDeleteDto.getId());
        } catch (UnknownTeamsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
