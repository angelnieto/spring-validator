package es.ricardo.springvalidator.validator;

import org.springframework.validation.Errors;

import es.ricardo.springvalidator.model.Company;

public class TaxBusinessValidator<T extends Company> extends MandatoryValidator<T>{
    private static final String field = "taxBusiness";
	
	public TaxBusinessValidator() {
        super(field, "Tax business is empty");
    }

    @Override
    public void validate(Object target, Errors errors) {
    	Company c = (Company) target;
    	if(c.getTaxBusiness() < 5) {
    		errors.rejectValue(field, "Tax business very low");
    	}
    }
}