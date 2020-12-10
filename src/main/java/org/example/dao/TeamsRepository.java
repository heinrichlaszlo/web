package org.example.dao;

import org.example.dao.entity.TeamsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeamsRepository extends CrudRepository<TeamsEntity, Integer>{

    @Override
    Optional<TeamsEntity> findById(Integer integer);

}
