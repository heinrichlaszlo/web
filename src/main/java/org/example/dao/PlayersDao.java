package org.example.dao;


import org.example.exception.UnknownPlayersException;
import org.example.model.Players;

import java.util.Collection;

public interface PlayersDao {

    void createPlayers(Players players);
    Collection<Players> readAll();
    void updatePlayers(Players players) throws UnknownPlayersException;
    void deletePlayers(int id) throws UnknownPlayersException;


}
