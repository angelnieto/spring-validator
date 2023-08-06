package es.ricardo.springvalidator.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import es.ricardo.springvalidator.model.Company;

public class TaxBusinessValidator<T extends Company> extends MandatoryValidator<T>{
    private static final String field = "taxBusiness";

    @Override
    public void validate(Object target, Errors errors) {
    	ValidationUtils.rejectIfEmpty(errors, field, "Tax business is empty");
    	 if(errors.getErrorCount() == 0) {
    	    	T c = (T) target;
    	    	if(c.getTaxBusiness() < 5) {
    	    		errors.rejectValue(field, "Tax business very low");
    	    	}
    	 }

    }
}