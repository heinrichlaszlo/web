package org.example.service;

import org.example.exception.UnknownPlayersException;
import org.example.model.Players;

import java.util.Collection;

public interface PlayersService {

    Collection<Players> getAllPlayers();

    void recordPlayers(Players player) throws UnknownPlayersException;
    void updatePlayers(Players player) throws UnknownPlayersException;
    void deletePlayers(int id) throws UnknownPlayersException;




}
