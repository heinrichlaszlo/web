package org.example.dao;

import org.example.dao.entity.PlayersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface PlayersRepository extends CrudRepository<PlayersEntity, Integer> {

    @Override
    Optional<PlayersEntity> findById(Integer integer);

    Collection<PlayersEntity> findByHeight(Integer integer);


}
