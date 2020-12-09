package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.PlayersDao;
import org.example.exception.UnknownMatchesException;
import org.example.exception.UnknownPlayersException;
import org.example.model.Players;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class PlayersServiceImpl implements PlayersService{

    private final PlayersDao playersDao;

    @Override
    public Collection<Players> getAllPlayers(){
        return playersDao.readAll();

    }

  /*  @Override
    public Collection<Players> getPlayersHeight(String last_name) {
        return playersDao.readAll().stream()
                .filter(players -> last_name.equals(players.getHeight()))
                collect(Collectors.toList());
    }
*/

@Override
    public void recordPlayers(Players players) throws UnknownPlayersException {
        playersDao.createPlayers(players);
    }
    @Override
    public void deletePlayer(String first_name) throws UnknownPlayersException {
        playersDao.deletePlayers(first_name);
    }
}

