package org.example.service;

import org.example.exception.UnknownTeamsException;
import org.example.model.Teams;

import java.util.Collection;

public interface TeamsService {

    Collection<Teams> getAllTeams();
    Collection<Teams> getTeamsTname(String tname);

    void recordTeams(Teams teams) throws UnknownTeamsException;
    void updateTeams(Teams teams) throws UnknownTeamsException;
    void deleteTeams(String name) throws UnknownTeamsException;
}
