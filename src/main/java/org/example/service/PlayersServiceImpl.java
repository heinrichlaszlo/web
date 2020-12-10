package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.PlayersDao;

import org.example.exception.UnknownPlayersException;
import org.example.model.Players;
import org.springframework.stereotype.Service;

import java.util.Collection;



@Slf4j
@Service
@RequiredArgsConstructor
public class PlayersServiceImpl implements PlayersService{
    private final PlayersDao playersDao;

    @Override
    public Collection<Players> getAllPlayers() {
        return playersDao.readAll();
    }

    @Override
    public void recordPlayers(Players player) throws UnknownPlayersException {
        playersDao.createPlayers(player);
    }

    @Override
    public void updatePlayers(Players player) throws UnknownPlayersException {
        playersDao.updatePlayers(player);
    }

    @Override
    public void deletePlayers(int id) throws UnknownPlayersException {
        playersDao.deletePlayers(id);
    }
}


