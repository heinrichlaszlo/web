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
    public Collection<Teams> getTeamsTname(String teams) {
        return teamsDao.readAll().stream()
                .filter(tname -> teams.equals(tname.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public void recordTeams(Teams teams) throws UnknownTeamsException {
        teamsDao.createTeams(teams);
    }

    @Override
    public void updateTeams(Teams teams) throws UnknownTeamsException {
        teamsDao.updateTeams(teams);
    }

    @Override
    public void deleteTeams(String name) throws UnknownTeamsException {
        teamsDao.deleteTeams(name);
    }
}

