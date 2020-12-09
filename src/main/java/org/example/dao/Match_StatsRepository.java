package org.example.dao;

import org.example.dao.entity.Match_StatsEntity;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface Match_StatsRepository extends CrudRepository<Match_StatsEntity, Integer> {

    @Override
    Optional<Match_StatsEntity> findById(Integer integer);

    Collection<Match_StatsEntity> findByLoc(String string);
}
