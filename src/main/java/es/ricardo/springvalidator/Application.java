package es.ricardo.springvalidator;

import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.ricardo.springvalidator.model.Company;
import es.ricardo.springvalidator.model.Customer;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Customer customer = new Customer();

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR_OF_DAY, 1);
        customer.setDeceasedDate(cal.getTime());
        
        
        Company company = new Company();
        cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, -1);
        company.setDeceasedDate(cal.getTime());
        company.setTaxBusiness(5);
       
        System.out.println(String.format("Customer Tax residence validation result : %d", customer.validateTaxResidence()));
        System.out.println(String.format("Customer Deceased Date validation result : %d", customer.validateDeceasedDate()));
        System.out.println(String.format("Customer Name validation result : %d", customer.validateName()));
        
        System.out.println(String.format("Company Deceased Date validation result : %d", company.validateDeceasedDate()));
        System.out.println(String.format("Company Tax residence validation result : %d", company.validateTaxResidence()));
        System.out.println(String.format("Company Tax business validation result : %d", company.validateTaxBusiness()));
        System.out.println(String.format("Company validation result : %d", company.validate()));
        
	}

}
