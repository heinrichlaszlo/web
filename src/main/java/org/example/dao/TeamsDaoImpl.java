package org.example.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.entity.TeamsEntity;
import org.example.exception.UnknownTeamsException;
import org.example.model.Teams;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j //ad egy logger változót
@RequiredArgsConstructor
public class TeamsDaoImpl implements TeamsDao {

    private final TeamsRepository teamsRepository;
    private final Match_StatsRepository match_statsRepository;


    @Override
    public void createTeams(Teams teams) throws UnknownTeamsException {
        TeamsEntity teamsEntity;

        teamsEntity = TeamsEntity.builder()
                .id(teams.getId())
                .name(teams.getName())
                .build();

        log.info("TeamsEntity: {}",teamsEntity);
        try {
            teamsRepository.save(teamsEntity);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }


    @Override
    public Collection<Teams> readAll() {
        log.info("Listing all players");
        return StreamSupport.stream(teamsRepository.findAll().spliterator(),false)
                .map(entity -> new Teams(
                        entity.getId(),
                        entity.getName()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void updateTeams(Teams teams) throws UnknownTeamsException {
        Optional<TeamsEntity> teamsEntity = teamsRepository.findById(teams.getId());
        if (teamsEntity.isEmpty()){
            throw new UnknownTeamsException(String.format("Team Not Found %s",teams));
        }
        teamsEntity.get().setName(teams.getName());

        try {
            teamsRepository.save(teamsEntity.get());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    @Override
    public void deleteTeams(int id) throws UnknownTeamsException {
        Optional<TeamsEntity> teamsEntity = teamsRepository.findById(id);
        if (teamsEntity.isEmpty()){
            throw new UnknownTeamsException(String.format("Team with this ID Not Found %s",id));
        }
        teamsRepository.delete(teamsEntity.get());
    }
}

