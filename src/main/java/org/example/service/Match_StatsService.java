package org.example.service;

import org.example.exception.UnknownMatchStatsException;
import org.example.model.MatchStats;

import java.util.Collection;

public interface Match_StatsService {

    Collection<MatchStats> getAllMatchStats();
    void recordMatchStats(MatchStats matchStats) throws UnknownMatchStatsException;
    void updateMatchStat(MatchStats matchStats) throws UnknownMatchStatsException;
    void deleteMatchStat(String mid, int pid) throws UnknownMatchStatsException;
}
