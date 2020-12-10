package org.example.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.entity.PlayersEntity;
import org.example.exception.UnknownPlayersException;
import org.example.model.Players;
import org.springframework.stereotype.Service;



import java.util.Collection;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlayersDaoImpl implements PlayersDao{

    private final PlayersRepository playersRepository;
    private final TeamsRepository teamsRepository;
    private final Match_StatsRepository match_statsRepository;


    @Override
    public void createPlayers(Players players) throws UnknownPlayersException {
        PlayersEntity playersEntity;



        playersEntity = PlayersEntity.builder()
                .id(players.getId())
                .dob(players.getDob())
                .first_name(players.getFirst_name())
                .last_name(players.getLast_name())
                .height(players.getHeight())
                .weight(players.getWeight())
                .build();
        if (playersEntity.getHeight() < 0){
            throw new UnknownPlayersException(String.format("height <0 ",players));
        }
        if (playersEntity.getWeight() < 0){
            throw new UnknownPlayersException(String.format("Weight <0 ",players));
        }
        if (playersEntity.getId() <= 0){
            throw new UnknownPlayersException(String.format("ID <= 0",players));
        }

        log.info("PlayersEntity: {}", playersEntity);
        try {
            playersRepository.save(playersEntity);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }



    @Override
    public Collection<Players> readAll() {
        log.info("Listing all players");
        return StreamSupport.stream(playersRepository.findAll().spliterator(),false)
                .map(entity -> new Players(
                        entity.getId(),
                        entity.getDob(),
                        entity.getFirst_name(),
                        entity.getLast_name(),
                        entity.getHeight(),
                        entity.getWeight()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void updatePlayers(Players players) throws UnknownPlayersException {
        Optional<PlayersEntity> playersEntity = playersRepository.findById(players.getId());
        if (playersEntity.isEmpty()){
            throw new UnknownPlayersException(String.format("Player Not Found %s",players));
        }
        playersEntity.get().setDob(players.getDob());
        playersEntity.get().setFirst_name(players.getFirst_name());
        playersEntity.get().setLast_name(players.getLast_name());
        playersEntity.get().setHeight(players.getHeight());
        playersEntity.get().setWeight(players.getWeight());

        try {
            playersRepository.save(playersEntity.get());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void deletePlayers(int id) throws UnknownPlayersException {
        Optional<PlayersEntity> playersEntity = playersRepository.findById(id);
        if (playersEntity.isEmpty()){
            throw new UnknownPlayersException(String.format("Player with this ID Not Found %s",id));
        }
        playersRepository.delete(playersEntity.get());
    }
    }




