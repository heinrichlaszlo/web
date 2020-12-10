package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.TeamsDao;
import org.example.exception.UnknownTeamsException;
import org.example.model.Teams;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamsServiceImpl implements TeamsService {


    private final TeamsDao teamsDao;

    @Override
    public Collection<Teams> getAllTeams() {
        return teamsDao.readAll();
    }

    @Override
    public void recordTeams(Teams teams) throws UnknownTeamsException {
        if (teams.getId()<=100){
            throw new UnknownTeamsException(String.format("Team ID is less than or equal to 100, ID: %d",teams.getId()));
        }
        teamsDao.createTeams(teams);
    }

    @Override
    public void updateTeams(Teams teams) throws UnknownTeamsException {
        if (teams.getId()<=100){
            throw new UnknownTeamsException(String.format("Team ID is less than or equal to 100, ID: %d",teams.getId()));
        }
        teamsDao.updateTeams(teams);
    }

    @Override
    public void deleteTeams(int id) throws UnknownTeamsException {
        teamsDao.deleteTeams(id);
    }
}
