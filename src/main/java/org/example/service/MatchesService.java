package org.example.service;

import org.example.exception.UnknownMatchesException;
import org.example.exception.UnknownTeamsException;
import org.example.model.Matches;

import java.util.Collection;

public interface MatchesService {

    Collection<Matches> getAllMatches();

    void recordMatch(Matches match) throws UnknownTeamsException;
    void updateMatch(Matches match) throws UnknownMatchesException;
    void deleteMatch(String id) throws UnknownMatchesException;

}