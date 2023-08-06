package es.ricardo.springvalidator.validator;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import es.ricardo.springvalidator.model.Customer;

public class DeceasedDateValidator<T extends Customer> extends MandatoryValidator<T> {

//	public DeceasedDateValidator(String field, String errCode) {
//		super("deceasedDate", "Deceased date is empty");
//	}

	@Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "deceasedDate", "Deceased date is empty");
        T order = (T) target;
        if (order.getDeceasedDate() != null &&
                order.getDeceasedDate().compareTo(new Date()) >= 0) {
            errors.rejectValue("deceasedDate", "Deceased date can not be in future");
        }
    }
}