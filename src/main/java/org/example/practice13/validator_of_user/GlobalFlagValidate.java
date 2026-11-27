package org.example.practice13.validator_of_user;

public class GlobalFlagValidate {
  private final boolean validationEnabled;

  public GlobalFlagValidate(boolean validationEnabled) {
    this.validationEnabled = validationEnabled;
  }

  public boolean isValidationEnabled() {
    return validationEnabled;
  }
}
