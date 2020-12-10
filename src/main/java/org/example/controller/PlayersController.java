package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.example.controller.dto.PlayersDeleteDto;
import org.example.controller.dto.PlayersDto;

import org.example.exception.UnknownPlayersException;
import org.example.model.Players;
import org.example.service.PlayersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.sql.Timestamp;
import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlayersController {

    private final PlayersService service;

    @GetMapping("/players")
    public Collection<PlayersDto> listPlayers(){
        return service.getAllPlayers().stream()
                .map(model -> new PlayersDto(
                        model.getId(),
                        model.getDob().toString(),
                        model.getFirst_name(),
                        model.getLast_name(),
                        model.getHeight(),
                        model.getWeight()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping("/players")
    public void recordPlayer(@RequestBody PlayersDto playersDto){
        try {
            service.recordPlayers(new Players(
                    playersDto.getId(),
                    Timestamp.valueOf(playersDto.getDob()),
                    playersDto.getFirst_name(),
                    playersDto.getLast_name(),
                    playersDto.getHeight(),
                    playersDto.getWeight()
            ));
        } catch (UnknownPlayersException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/players/update")
    public void updatePlayer(@RequestBody PlayersDto playersDto){
        try {
            service.updatePlayers(new Players(
                    playersDto.getId(),
                    Timestamp.valueOf(playersDto.getDob()),
                    playersDto.getFirst_name(),
                    playersDto.getLast_name(),
                    playersDto.getHeight(),
                    playersDto.getWeight()
            ));
        } catch (UnknownPlayersException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/players")
    public void deletePlayer(@RequestBody PlayersDeleteDto playersDeleteDto){
        try {
            service.deletePlayers(playersDeleteDto.getId());
        } catch (UnknownPlayersException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
