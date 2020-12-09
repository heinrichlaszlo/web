package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.MatchesDao;
import org.example.exception.UnknownMatchesException;
import org.example.exception.UnknownTeamsException;
import org.example.model.Matches;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchesServiceImpl implements MatchesService {

    private final MatchesDao matchesDao;

    @Override
    public Collection<Matches> getAllMatches() {
        return matchesDao.readAll();
    }

    @Override
    public void recordMatch(Matches match) throws UnknownTeamsException {
        matchesDao.createMatch(match);
    }

    @Override
    public void updateMatch(Matches match) throws UnknownMatchesException {
        matchesDao.updateMatch(match);
    }

    @Override
    public void deleteMatch(String id) throws UnknownMatchesException {
        matchesDao.deleteMatch(id);
    }
}
