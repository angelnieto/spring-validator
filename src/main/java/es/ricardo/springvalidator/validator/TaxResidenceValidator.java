package es.ricardo.springvalidator.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import es.ricardo.springvalidator.model.Customer;

public class TaxResidenceValidator<T extends Customer> extends MandatoryValidator<T> {
    private static final String field = "taxResidence";

    @Override
    public void validate(Object target, Errors errors) {
    	ValidationUtils.rejectIfEmpty(errors, field, "Tax residence is empty");
    	if(errors.getErrorCount() == 0) {
        	T c = (T) target;
        	if(c.getTaxResidence() < 35) {
        		errors.rejectValue(field, "Tax residence very low");
        	}
    	}

    }
}