package org.example.dao;

import org.example.exception.UnknownMatchesException;
import org.example.exception.UnknownTeamsException;
import org.example.model.Matches;


import java.util.Collection;

public interface MatchesDao {

    void createMatch(Matches match) throws UnknownTeamsException;


    Collection<Matches> readAll();

    void updateMatch(Matches match) throws UnknownMatchesException;

    void deleteMatch(String id) throws UnknownMatchesException;

}