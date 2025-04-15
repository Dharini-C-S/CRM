package testng;

import org.testng.annotations.Test;

public class Demo {

	@Test (priority = 3, groups = "RegressionTest")
	public void createContact() {
		
		System.out.println("Contact created");
	}
	
	@Test(priority = 2, dependsOnMethods = "createContact", groups = "RegressionTest")
	public void deleteContact() {
		System.out.println("Contact deleted");
	}
	
	@Test(priority = 0, dependsOnMethods = "createContact", groups = "RegressionTest")
	public void modifyContact() {
		System.out.println("Contact modified");
	}
}
