package org.example.dao;

import org.example.exception.UnknownMatchStatsException;

import org.example.model.MatchStats;

import java.util.Collection;

public interface Match_StatsDao {

    void createMatch_Stats(MatchStats matchStats);
    Collection<MatchStats> readAll();
    void updateMatchStat(MatchStats matchStats) throws UnknownMatchStatsException;

    void deleteMatchStat(String mid, int pid) throws UnknownMatchStatsException;
}

