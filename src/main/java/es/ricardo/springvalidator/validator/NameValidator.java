package es.ricardo.springvalidator.validator;

import es.ricardo.springvalidator.model.Customer;

public class NameValidator<T extends Customer> extends MandatoryValidator<T> {
    public NameValidator() {
        super("name", "Name is empty");
    }
}