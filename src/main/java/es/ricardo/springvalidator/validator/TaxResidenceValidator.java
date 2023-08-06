package es.ricardo.springvalidator.validator;

public class TaxResidenceValidator extends MandatoryValidator {
    public TaxResidenceValidator() {
        super("taxResidence", "Tax residence is empty");
    }
}