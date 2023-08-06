package es.ricardo.springvalidator.validator;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import es.ricardo.springvalidator.model.Customer;

public class DeceasedDateValidator<T extends Customer> extends MandatoryValidator<T> {

	private static final String field = "deceasedDate";

	@Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, field, "Deceased date is empty");
        T order = (T) target;
        if (order.getDeceasedDate() != null &&
                order.getDeceasedDate().compareTo(new Date()) >= 0) {
            errors.rejectValue(field, "Deceased date can not be in future");
        }
    }
}