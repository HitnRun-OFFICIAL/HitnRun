package com.HitnRun.validations;

import com.HitnRun.handlers.InvalidInputException;
import com.HitnRun.models.CustomerDTO;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.RegexValidator;

public class InputValidation {

  public static void validateName(String name) throws InvalidInputException {
    if (!new RegexValidator("^[A-Za-z]+").isValid(name)) {
      throw new InvalidInputException("Invalid name. Please provide a valid name.");
    }
  }

  public static void validateEmail(String email) throws InvalidInputException {
    if (!EmailValidator.getInstance().isValid(email)) {
      throw new InvalidInputException("Invalid email. Please provide a valid email address.");
    }
  }

  public static void validatePhone(String phone) throws InvalidInputException {
    if (!new RegexValidator("^[0-9]{10}").isValid(phone)) {
      throw new InvalidInputException(
          "Invalid phone number. Please provide a valid 10-digit phone number.");
    }
  }

  public static void validatePassword(String password) throws InvalidInputException {
    if (password == null || password.length() < 8) {
      throw new InvalidInputException(
          "Invalid password. Password should be at least 8 characters long.");
    }
  }

  public static void validateProfile(CustomerDTO profile) throws InvalidInputException {
    validateName(profile.getFirstName());
    validateName(profile.getLastName());
    validateName(profile.getUsername());
    validateEmail(profile.getEmail());
    validatePhone(profile.getPhone());
    validatePassword(new String(profile.getPassword()));
  }
}
