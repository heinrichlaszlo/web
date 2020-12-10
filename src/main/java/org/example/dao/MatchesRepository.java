package org.example.dao;

import org.example.dao.entity.MatchesEntity;
import org.springframework.data.repository.CrudRepository;



public interface MatchesRepository extends CrudRepository<MatchesEntity, Integer> {

}
