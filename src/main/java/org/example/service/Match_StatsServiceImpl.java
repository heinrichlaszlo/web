package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.Match_StatsDao;
import org.example.exception.UnknownMatchStatsException;
import org.example.model.MatchStats;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class Match_StatsServiceImpl implements Match_StatsService {

    private final Match_StatsDao match_statsDao;

    @Override
    public Collection<MatchStats> getAllMatchStats(){

        return match_statsDao.readAll();
    }
    @Override
    public void recordMatchStats(MatchStats matchStats) throws UnknownMatchStatsException{
        match_statsDao.createMatch_Stats(matchStats);
    }

    @Override
    public void updateMatchStat(MatchStats matchStats) throws UnknownMatchStatsException {
        match_statsDao.updateMatchStat(matchStats);
    }

    @Override
    public void deleteMatchStat(String mid, int pid) throws UnknownMatchStatsException {
        match_statsDao.deleteMatchStat(mid,pid);
    }
}
