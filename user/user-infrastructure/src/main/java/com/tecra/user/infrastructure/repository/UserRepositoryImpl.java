package com.tecra.user.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import com.tecra.user.infrastructure.mapper.UserEntityMapper;
import com.tecra.user.domain.entity.User;
import com.tecra.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final UserJpaRepository userJpaRepository;

  private final UserEntityMapper userMapper;

  @Override
  public void saveUser(final User user) {
    this.userJpaRepository.save(this.userMapper.fromDomain(user));
  }

  @Override
  public void deleteUserById(final Integer userId) {
    this.userJpaRepository.deleteById(userId);
  }

  @Override
  public List<User> readUsers() {
    return this.userMapper.toDomain(this.userJpaRepository.findAll());
  }

  @Override
  public Optional<User> findUserById(final Integer userId) {
    return this.userJpaRepository.findById(userId).map(this.userMapper::toDomain);
  }

  @Override
  public Optional<User> findUserByIdentification(final String identification) {
    return this.userJpaRepository.findByIdentification(identification).map(this.userMapper::toDomain);
  }
}
