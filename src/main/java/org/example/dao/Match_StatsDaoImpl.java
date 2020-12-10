package org.example.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.entity.Match_StatsEntity;
import org.example.exception.UnknownMatchStatsException;
import org.example.exception.UnknownMatchesException;
import org.example.exception.UnknownPlayersException;
import org.example.exception.UnknownTeamsException;
import org.example.model.MatchStats;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class Match_StatsDaoImpl implements Match_StatsDao{

    private final PlayersRepository playersRepository;
    private final TeamsRepository teamsRepository;
    private final Match_StatsRepository match_statsRepository;

    @Override
    public void createMatch_Stats(MatchStats matchStats){
        Match_StatsEntity match_statsEntity = null;

        match_statsEntity = Match_StatsEntity.builder()
                .loc(matchStats.getLoc())
                .ki(matchStats.getKi())
                .mk(matchStats.getMk())
                .mb(matchStats.getMb())
                .di(matchStats.getDi())
                .gl(matchStats.getGl())
                .bh(matchStats.getBh())
                .ho(matchStats.getHo())
                .tk(matchStats.getTk())
                .rb(matchStats.getRb())
                .lf(matchStats.getLf())
                .cl(matchStats.getCl())
                .cg(matchStats.getCg())
                .ff(matchStats.getFf())
                .fa(matchStats.getFa())
                .br(matchStats.getBr())
                .cp(matchStats.getCp())
                .up(matchStats.getUp())
                .cm(matchStats.getCm())
                .mi(matchStats.getMi())
                .lp(matchStats.getLp())
                .bo(matchStats.getBo())
                .ga(matchStats.getGa())
                .pp(matchStats.getPp())
                .build();

        log.info("Match_statsEntity: ",match_statsEntity);
       try{
           match_statsRepository.save(match_statsEntity);
       }catch(Exception e){
           log.error(e.getMessage());
       }
    }


    @Override
    public Collection<MatchStats> readAll(){
        log.info("Listing all match stats");
        return StreamSupport.stream(match_statsRepository.findAll().spliterator(), false)
                .map(entity -> new MatchStats(

                        entity.getLoc(),
                        entity.getKi(),
                        entity.getMk(),
                        entity.getMb(),
                        entity.getDi(),
                        entity.getGl(),
                        entity.getBh(),
                        entity.getHo(),
                        entity.getTk(),
                        entity.getRb(),
                        entity.getLf(),
                        entity.getCl(),
                        entity.getCg(),
                        entity.getFf(),
                        entity.getFa(),
                        entity.getBr(),
                        entity.getCp(),
                        entity.getUp(),
                        entity.getCm(),
                        entity.getMi(),
                        entity.getLp(),
                        entity.getBo(),
                        entity.getGa(),
                        entity.getPp()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void updateMatchStat(MatchStats matchStats) throws UnknownMatchStatsException{
    }

    @Override
    public void deleteMatchStat( String mid ,int pid) throws UnknownMatchStatsException {
        Optional<Match_StatsEntity> matchStatsEntity = match_statsRepository.findById(pid);
        /*if (matchStatsEntity.isEmpty()) {
            throw new UnknownMatchStatsException(String.format("MatchStat with this ID Not Found %s",
                    pid);
        }*/

        match_statsRepository.delete(matchStatsEntity.get());

    }
    }

