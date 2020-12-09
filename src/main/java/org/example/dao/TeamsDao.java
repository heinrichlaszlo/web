package org.example.dao;

import org.example.exception.UnknownTeamsException;
import org.example.model.Teams;

import java.util.Collection;

public interface TeamsDao {

    void createTeams(Teams teams) throws UnknownTeamsException;
    Collection<Teams>  readAll();

    void updateTeams(Teams teams) throws UnknownTeamsException;

    void deleteTeams(String name) throws UnknownTeamsException;
}
