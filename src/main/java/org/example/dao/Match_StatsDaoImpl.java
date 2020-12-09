package org.example.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.entity.Match_StatsEntity;
import org.example.model.MatchStats;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
        match_statsRepository.save(match_statsEntity);
    }


    @Override
    public Collection<MatchStats> readAll(){
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
}
