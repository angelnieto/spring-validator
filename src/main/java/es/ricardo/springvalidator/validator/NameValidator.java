package es.ricardo.springvalidator.validator;

import es.ricardo.springvalidator.model.Customer;

public class NameValidator extends MandatoryValidator {
    public NameValidator() {
        super("name", "Name is empty");
    }
}