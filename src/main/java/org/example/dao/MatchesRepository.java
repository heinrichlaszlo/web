package org.example.dao;

import org.example.dao.entity.MatchesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface MatchesRepository extends CrudRepository<MatchesEntity, Integer> {

}
