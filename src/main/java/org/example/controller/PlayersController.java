package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.controller.dto.MatchesDeleteDto;
import org.example.controller.dto.PlayersDeleteDto;
import org.example.controller.dto.PlayersDto;
import org.example.exception.UnknownMatchesException;
import org.example.exception.UnknownPlayersException;
import org.example.service.PlayersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlayersController {

    private final PlayersService service;

    @GetMapping("/players")
    public Collection<PlayersDto> listPlayers(){
       return service.getAllPlayers()
       .stream()
       .map(model -> PlayersDto.builder()
               .first_name(model.getFirst_name())
               .last_name(model.getLast_name())
               .height(model.getHeight())
               .weight(model.getWeight())
               .build())
       .collect(Collectors.toList()) ;
    }

    @DeleteMapping("/players/delete")
    public void deletePlayer(@RequestBody PlayersDeleteDto playersDto) throws UnknownPlayersException {
         service.deletePlayer(playersDto.getFirst_name());

    }
}
