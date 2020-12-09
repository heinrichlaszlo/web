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
    public void createTeams(Teams teams){
        TeamsEntity teamsEntity = null;
      /*  if(!teamsEntity.isPresent()){

        }

       */
        teamsEntity = TeamsEntity.builder()
                .name(teams.getName())
                .build();
        teamsRepository.save(teamsEntity);
    }


    @Override
    public Collection<Teams> readAll() {
        log.info("Listing all teams");
        return StreamSupport.stream(teamsRepository.findAll().spliterator(), false)
                .map(entity -> new Teams(entity.getName())).collect(Collectors.toList());
    }

    @Override
    public void updateTeams(Teams teams) throws UnknownTeamsException {
        Optional<TeamsEntity> teamsEntity = StreamSupport.stream(teamsRepository.findAll().spliterator(), false).filter(
                entity -> entity.getName().equals(teams.getName())
        ).findAny();
        if (teamsEntity.isEmpty()) {
            throw new UnknownTeamsException(String.format("Teams not found %s", teams));
        } else {
            teamsEntity.get().setName(teams.getName());
        }
        try {
            teamsRepository.save(teamsEntity.get());
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    @Override
    public void deleteTeams(String name) throws UnknownTeamsException {
        Optional<TeamsEntity> teamsEntity = StreamSupport.stream(teamsRepository.findAll().spliterator(),false).filter(
                entity -> name.equals(entity.getName())
        ).findAny();
        if(teamsEntity.isEmpty()){
            throw new UnknownTeamsException(String.format("team with this name not foung %s",name));
        }
        teamsRepository.delete(teamsEntity.get());
    }

}
