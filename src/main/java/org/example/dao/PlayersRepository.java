package org.example.dao;

import org.example.dao.entity.PlayersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface PlayersRepository extends CrudRepository<PlayersEntity, Integer> {


    Optional<PlayersEntity> findById(Integer id);



}
