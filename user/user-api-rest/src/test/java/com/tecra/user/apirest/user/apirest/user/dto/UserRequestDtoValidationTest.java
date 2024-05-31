package com.tecra.user.apirest.user.apirest.user.dto;

import static com.tecra.user.apirest.user.constants.UserValidationMessageConstants.ACTIVE_MESSAGE;
import static com.tecra.user.apirest.user.constants.UserValidationMessageConstants.ADDRESS_LENGTH_MESSAGE;
import static com.tecra.user.apirest.user.constants.UserValidationMessageConstants.AGE_MAX_MESSAGE;
import static com.tecra.user.apirest.user.constants.UserValidationMessageConstants.AGE_MIN_MESSAGE;
import static com.tecra.user.apirest.user.constants.UserValidationMessageConstants.IDENTIFICATION_LENGTH_MESSAGE;
import static com.tecra.user.apirest.user.constants.UserValidationMessageConstants.NAME_IS_REQUIRED_MESSAGE;
import static com.tecra.user.apirest.user.constants.UserValidationMessageConstants.NAME_LENGTH_MESSAGE;
import static com.tecra.user.apirest.user.constants.UserValidationMessageConstants.PASSWORD_LENGTH_MESSAGE;
import static com.tecra.user.apirest.user.constants.UserValidationMessageConstants.PHONE_LENGTH_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import com.tecra.user.apirest.user.dto.UserRequestDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class UserRequestDtoValidationTest {

  private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  @Nested
  class NameField {

    @Test
    void given_userWithNullName_when_validate_then_expectedViolations() {
      Set<ConstraintViolation<UserRequestDto>> violations =
          UserRequestDtoValidationTest.this.validator.validate(UserRequestDtoMother.withName(null));

      assertEquals(1, violations.size());
      assertEquals(NAME_IS_REQUIRED_MESSAGE, violations.iterator().next().getMessage());
    }

    @Test
    void given_userWithEmptyName_when_validate_then_expectedViolations() {
      Set<ConstraintViolation<UserRequestDto>> violations =
          UserRequestDtoValidationTest.this.validator.validate(UserRequestDtoMother.withName(""));

      assertEquals(1, violations.size());
      assertEquals(NAME_LENGTH_MESSAGE, violations.iterator().next().getMessage());
    }
  }

  @Nested
  class AgeField {

    @Test
    void given_userWithNullAge_when_validate_then_expectedViolations() {
      Set<ConstraintViolation<UserRequestDto>> violations =
          UserRequestDtoValidationTest.this.validator.validate(UserRequestDtoMother.withAge(null));

      assertEquals(1, violations.size());
      assertEquals(AGE_MIN_MESSAGE, violations.iterator().next().getMessage());
    }

    @Test
    void given_userWithNegativeAge_when_validate_then_expectedViolations() {
      Set<ConstraintViolation<UserRequestDto>> violations =
          UserRequestDtoValidationTest.this.validator.validate(UserRequestDtoMother.withAge(-1));

      assertEquals(1, violations.size());
      assertEquals(AGE_MIN_MESSAGE, violations.iterator().next().getMessage());
    }

    @Test
    void given_userWithTooMuchAge_when_validate_then_expectedViolations() {
      Set<ConstraintViolation<UserRequestDto>> violations =
          UserRequestDtoValidationTest.this.validator.validate(UserRequestDtoMother.withAge(101));

      assertEquals(1, violations.size());
      assertEquals(AGE_MAX_MESSAGE, violations.iterator().next().getMessage());
    }
  }

  @Nested
  class IdentificationField {

    @Test
    void given_userWithNullIdentification_when_validate_then_expectedViolations() {
      Set<ConstraintViolation<UserRequestDto>> violations =
          UserRequestDtoValidationTest.this.validator.validate(UserRequestDtoMother.withIdentification(null));

      assertEquals(1, violations.size());
      assertEquals(IDENTIFICATION_LENGTH_MESSAGE, violations.iterator().next().getMessage());
    }

    @Test
    void given_userWithEmptyIdentification_when_validate_then_expectedViolations() {
      Set<ConstraintViolation<UserRequestDto>> violations =
          UserRequestDtoValidationTest.this.validator.validate(UserRequestDtoMother.withIdentification(""));

      assertEquals(1, violations.size());
      assertEquals(IDENTIFICATION_LENGTH_MESSAGE, violations.iterator().next().getMessage());
    }
  }

  @Nested
  class AddressField {

    @Test
    void given_userWithNullAddress_when_validate_then_expectedViolations() {
      Set<ConstraintViolation<UserRequestDto>> violations =
          UserRequestDtoValidationTest.this.validator.validate(UserRequestDtoMother.withAddress(null));

      assertEquals(1, violations.size());
      assertEquals(ADDRESS_LENGTH_MESSAGE, violations.iterator().next().getMessage());
    }

    @Test
    void given_userWithEmptyAddress_when_validate_then_expectedViolations() {
      Set<ConstraintViolation<UserRequestDto>> violations =
          UserRequestDtoValidationTest.this.validator.validate(UserRequestDtoMother.withAddress(""));

      assertEquals(1, violations.size());
      assertEquals(ADDRESS_LENGTH_MESSAGE, violations.iterator().next().getMessage());
    }
  }

  @Nested
  class PhoneField {

    @Test
    void given_userWithNullPhone_when_validate_then_expectedViolations() {
      Set<ConstraintViolation<UserRequestDto>> violations =
          UserRequestDtoValidationTest.this.validator.validate(UserRequestDtoMother.withPhone(null));

      assertEquals(1, violations.size());
      assertEquals(PHONE_LENGTH_MESSAGE, violations.iterator().next().getMessage());
    }

    @Test
    void given_userWithEmptyPhone_when_validate_then_expectedViolations() {
      Set<ConstraintViolation<UserRequestDto>> violations =
          UserRequestDtoValidationTest.this.validator.validate(UserRequestDtoMother.withPhone(""));

      assertEquals(1, violations.size());
      assertEquals(PHONE_LENGTH_MESSAGE, violations.iterator().next().getMessage());
    }
  }

  @Nested
  class PasswordField {

    @Test
    void given_userWithNullPassword_when_validate_then_expectedViolations() {
      Set<ConstraintViolation<UserRequestDto>> violations =
          UserRequestDtoValidationTest.this.validator.validate(UserRequestDtoMother.withPassword(null));

      assertEquals(1, violations.size());
      assertEquals(PASSWORD_LENGTH_MESSAGE, violations.iterator().next().getMessage());
    }

    @Test
    void given_userWithEmptyPassword_when_validate_then_expectedViolations() {
      Set<ConstraintViolation<UserRequestDto>> violations =
          UserRequestDtoValidationTest.this.validator.validate(UserRequestDtoMother.withPassword(""));

      assertEquals(1, violations.size());
      assertEquals(PASSWORD_LENGTH_MESSAGE, violations.iterator().next().getMessage());
    }
  }

  @Nested
  class ActiveField {

    @Test
    void given_userWithNullActive_when_validate_then_expectedViolations() {
      Set<ConstraintViolation<UserRequestDto>> violations =
          UserRequestDtoValidationTest.this.validator.validate(UserRequestDtoMother.withActive(null));

      assertEquals(1, violations.size());
      assertEquals(ACTIVE_MESSAGE, violations.iterator().next().getMessage());
    }
  }
}
