package es.ricardo.springvalidator.validator;

public class NameValidator extends MandatoryValidator {
    public NameValidator() {
        super("name", "Name is empty");
    }
}