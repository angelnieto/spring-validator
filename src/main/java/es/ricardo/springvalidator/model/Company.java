package es.ricardo.springvalidator.model;

import org.springframework.validation.DataBinder;

import es.ricardo.springvalidator.validator.TaxBusinessValidator;

public class Company extends Customer{
    private Integer taxBusiness;

    public Integer getTaxBusiness() {
		return taxBusiness;
	}

	public void setTaxBusiness(Integer taxBusiness) {
		this.taxBusiness = taxBusiness;
	}

	public int validateTaxBusiness() {
    	DataBinder dataBinder = new DataBinder(this);
    	dataBinder.addValidators(new TaxBusinessValidator<Company>());
    	return getValidation(dataBinder) == 0 ? 1 : 0;
    }
       
    public int validate() {
    	return super.validate() * validateTaxBusiness();
    }

	private int getValidation(DataBinder dataBinder) {
		dataBinder.validate();
		return dataBinder.getBindingResult().getFieldErrors().size();
	}

}