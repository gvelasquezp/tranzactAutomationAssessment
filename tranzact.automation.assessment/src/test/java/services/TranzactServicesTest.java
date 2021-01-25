package services;

import org.testng.annotations.Test;

public class TranzactServicesTest extends ServicesTest{
	
	@Test
	public void verifyCountryGB() throws Exception {
		
		verifyCountry("GB");
		
	}
	
	@Test
	public void verifyCountryUS() throws Exception {
		
		verifyCountry("US");
		
	}
	
	@Test
	public void verifyCountryDE() throws Exception {
		
		verifyCountry("DE");
		
	}
	
	@Test
	public void verifyInexistentCountryXW() throws Exception {
		
		verifyInexistentCountry("XW");
		
	}
	
	@Test //NOT EXECUTE
	public void verifyCreateCountryTEST() throws Exception {
		
		//verifyCreateCountry("Test Country","TC","TCY");
		
	}

}
