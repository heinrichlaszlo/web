package org.example.dao;

import org.example.model.MatchStats;

import java.util.Collection;

public interface Match_StatsDao {

    void createMatch_Stats(MatchStats matchStats);
    Collection<MatchStats> readAll();
}
