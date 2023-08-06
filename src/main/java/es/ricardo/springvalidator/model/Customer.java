package es.ricardo.springvalidator.model;

import java.util.Date;

import org.springframework.validation.DataBinder;

import es.ricardo.springvalidator.validator.DeceasedDateValidator;
import es.ricardo.springvalidator.validator.NameValidator;
import es.ricardo.springvalidator.validator.TaxResidenceValidator;

public class Customer{
    private String taxResidence;
    private String name;
    private Date deceasedDate;

    public String getTaxResidence() {
        return taxResidence;
    }

    public void setTaxResidence(String taxResidence) {
        this.taxResidence = taxResidence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeceasedDate() {
        return deceasedDate;
    }

    public void setDeceasedDate(Date deceasedDate) {
        this.deceasedDate = deceasedDate;
    }

    public int validateTaxResidence() {
    	DataBinder dataBinder = new DataBinder(this);
    	dataBinder.addValidators(new TaxResidenceValidator());
    	return getValidation(dataBinder) == 0 ? 1 : 0;
    }
    
    public int validateDeceasedDate() {
    	DataBinder dataBinder = new DataBinder(this);
    	dataBinder.addValidators(new DeceasedDateValidator());
    	return getValidation(dataBinder) == 0 ? 1 : 0;
    }
    
    public int validateName() {
    	DataBinder dataBinder = new DataBinder(this);
    	dataBinder.addValidators(new NameValidator());
    	return getValidation(dataBinder) == 0 ? 1 : 0;
    }
    
    public int validate() {
    	return validateTaxResidence() * validateDeceasedDate() * validateName();
    }

	private int getValidation(DataBinder dataBinder) {
		dataBinder.validate();
		return dataBinder.getBindingResult().getFieldErrors().size();
	}

}