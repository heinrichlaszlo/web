package org.example.service;

import org.example.exception.UnknownPlayersException;
import org.example.model.Players;

import java.util.Collection;

public interface PlayersService {

    Collection<Players> getAllPlayers();
    //Collection<Players> getPlayersHeight(String last_name);

   void recordPlayers(Players players) throws UnknownPlayersException;
   void deletePlayer(String first_name) throws UnknownPlayersException;


}
