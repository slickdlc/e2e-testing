package com.devsu.user.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import com.devsu.user.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends CrudRepository<UserEntity, Integer> {

  List<UserEntity> findAll();
  
  Optional<UserEntity> findByIdentification(final String identification);
  
}
