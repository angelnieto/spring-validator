package es.ricardo.springvalidator.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.ricardo.springvalidator.model.Customer;

public abstract class MandatoryValidator<T extends Customer> implements Validator {
    private String field;
    private String errCode;

    public MandatoryValidator() {}

    public MandatoryValidator(String field, String errCode) {
        this.field = field;
        this.errCode = errCode;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, errCode);
    }
}