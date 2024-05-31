package com.tecra.user.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tecra.UserMother;
import com.tecra.user.config.ApplicationAbstractIT;
import com.tecra.user.domain.entity.User;
import com.tecra.user.domain.repository.UserRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryIT extends ApplicationAbstractIT {

  private static final Integer USER_ID_THAT_EXISTS = 1;

  private static final String ADDRESS = "Av. 28 de Julio #1999";

  private static final Integer AGE = 26;

  private static final String GENDER = "M";

  private static final String IDENTIFICATION_THAT_EXISTS = "71717171";

  private static final String NAME = "Hans De La Cruz Acosta";

  private static final String PASSWORD = "passw0rd";

  private static final String PHONE = "959825887";

  private static final Boolean ACTIVE = true;

  @Autowired
  private UserRepository userRepository;

  private void validateExpectUser(final User user) {
    assertEquals(USER_ID_THAT_EXISTS, user.getUserId());
    assertEquals(ADDRESS, user.getAddress());
    assertEquals(AGE, user.getAge());
    assertEquals(GENDER, user.getGender());
    assertEquals(IDENTIFICATION_THAT_EXISTS, user.getIdentification());
    assertEquals(NAME, user.getName());
    assertEquals(PASSWORD, user.getPassword());
    assertEquals(PHONE, user.getPhone());
    assertEquals(ACTIVE, user.isActive());
  }

  @Nested
  class SaveUser {

    private static final String IDENTIFICATION_DOES_NOT_EXIST = "12341234";

    private static final String IDENTIFICATION_DOES_NOT_EXIST_TWO = "12341235";

    private static final Integer USER_ID_TO_UPDATE = 3;

    @Test
    void given_userToCreate_when_saveUser_then_userIsCreated() {
      final User user = UserMother.builder().userId(null).identification(IDENTIFICATION_DOES_NOT_EXIST).build();

      UserRepositoryIT.this.userRepository.saveUser(user);
      final var userCreated = UserRepositoryIT.this.userRepository.findUserByIdentification(IDENTIFICATION_DOES_NOT_EXIST);

      assertNotNull(userCreated);
      assertTrue(userCreated.isPresent());
      assertNotNull(userCreated.get().getUserId());
      assertEquals(IDENTIFICATION_DOES_NOT_EXIST, userCreated.get().getIdentification());
    }

    @Test
    void given_userToUpdate_when_saveUser_then_userIsUpdated() {
      final User user =
          UserMother.builder().userId(USER_ID_TO_UPDATE).identification(IDENTIFICATION_DOES_NOT_EXIST_TWO).build();

      UserRepositoryIT.this.userRepository.saveUser(user);
      final var userUpdated = UserRepositoryIT.this.userRepository.findUserByIdentification(IDENTIFICATION_DOES_NOT_EXIST_TWO);

      assertNotNull(userUpdated);
      assertTrue(userUpdated.isPresent());
      assertEquals(USER_ID_TO_UPDATE, userUpdated.get().getUserId());
      assertEquals(IDENTIFICATION_DOES_NOT_EXIST_TWO, userUpdated.get().getIdentification());
    }
  }

  @Nested
  class DeleteUser {

    private static final Integer USER_ID_TO_DELETE = 2;

    @Test
    void given_validUserId_when_deleteUser_then_userIsDeleted() {
      final var userBeforeDelete = UserRepositoryIT.this.userRepository.findUserById(USER_ID_TO_DELETE);

      UserRepositoryIT.this.userRepository.deleteUserById(USER_ID_TO_DELETE);

      final var userDeleted = UserRepositoryIT.this.userRepository.findUserById(USER_ID_TO_DELETE);

      assertNotNull(userBeforeDelete);
      assertTrue(userBeforeDelete.isPresent());
      assertNotNull(userDeleted);
      assertTrue(userDeleted.isEmpty());
    }
  }

  @Nested
  class ReadUsers {

    @Test
    void given_nothing_when_readUsers_then_returnUsers() {
      final var users = UserRepositoryIT.this.userRepository.readUsers();

      assertNotNull(users);
      assertTrue(users.size() > 1);
      final var optionalUser = users.stream().filter(c -> USER_ID_THAT_EXISTS.equals(c.getUserId())).findFirst();
      assertTrue(optionalUser.isPresent());
      final var user = optionalUser.get();
      validateExpectUser(user);
    }
  }

  @Nested
  class FindUserById {

    @Test
    void given_idThatExists_when_findUserById_then_returnUsers() {
      final var user = UserRepositoryIT.this.userRepository.findUserById(USER_ID_THAT_EXISTS);

      assertNotNull(user);
      assertTrue(user.isPresent());
      validateExpectUser(user.get());
    }
  }

  @Nested
  class FindUserByIdentification {

    @Test
    void given_identificationThatExists_when_findUserByIdentification_then_returnUsers() {
      final var user = UserRepositoryIT.this.userRepository.findUserByIdentification(IDENTIFICATION_THAT_EXISTS);

      assertNotNull(user);
      assertTrue(user.isPresent());
      validateExpectUser(user.get());
    }
  }
}