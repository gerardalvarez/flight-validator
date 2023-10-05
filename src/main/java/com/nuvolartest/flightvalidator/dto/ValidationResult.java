package com.nuvolartest.flightvalidator.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
    private boolean isValid;
    private List<String> errorMessages = new ArrayList<>();


    public ValidationResult() {}
    public ValidationResult(boolean isValid) {
        this.isValid = isValid;
    }

    public ValidationResult(boolean isValid, List<String> errorMessages) {
        this.isValid = isValid;
        this.errorMessages = errorMessages;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public void addErrorMessage(String errorMessage) {
        this.isValid = false; // Set the validation result to false
        this.errorMessages.add(errorMessage);
    }

}
