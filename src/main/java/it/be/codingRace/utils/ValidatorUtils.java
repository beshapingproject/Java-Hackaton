package it.be.codingRace.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidatorUtils {

  public static <T> String validateRequestAndGetErrorMessage(T dto) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<T>> violations = validator.validate(dto);
    if (!violations.isEmpty()) {
      List<String> violationMessages = new ArrayList<String>();
      for (ConstraintViolation<T> violation : violations) {
        violationMessages.add(violation.getMessage());
      }
      String errorMessage = String.join(", ", violationMessages);
      return errorMessage;
    }
    return null;
  }
}
