package org.example.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.entity.PlayersEntity;
import org.example.exception.UnknownPlayersException;
import org.example.model.Players;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.Collection;

import java.util.Date;
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
    public void createPlayers(Players players){
        PlayersEntity playersEntity = null;

        playersEntity = PlayersEntity.builder()
                .dob(new Timestamp((new Date()).getTime()))
                .first_name(players.getFirst_name())
                .last_name(players.getLast_name())
                .height(players.getHeight())
                .weight(players.getWeight())
                .build();
        playersRepository.save(playersEntity);
    }

    @Override
    public Collection<Players> readAll(){
      return StreamSupport.stream(playersRepository.findAll().spliterator(),false)
              .map(entity -> new Players(

                      entity.getFirst_name(),
                      entity.getLast_name(),
                      entity.getHeight(),
                      entity.getWeight()
              ))
              .collect(Collectors.toList());
  }

  @Override
    public void deletePlayers(String first_name) throws UnknownPlayersException{
      Optional<PlayersEntity> playersEntity = StreamSupport.stream(playersRepository.findAll().spliterator(), false).filter(
              entity -> first_name.equals(entity.getFirst_name())
      ).findAny();
      if(playersEntity.isEmpty()){
          throw new UnknownPlayersException(String.format("Player with this ID not forund",first_name));
      }
      playersRepository.delete(playersEntity.get());
  }

}
