package testng_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependency {
	/*
	 * @Test annotation -> Helper Attributes
	 * 1. Priority
	 * 		To change the order of execution
	 * 		Lesser the value - earlier the execution
	 * 		default value => 0
	 * 2. DependsOnMethods
	 * 		whenever we want to create dependency btwn 2 test cases
	 *		 		
	*/
	
//	PRIORITY
	
//	@Test(priority = -1)
//	public void createCity() {
//		System.out.println("Noida");
//		Assert.assertTrue(false);
//		System.out.println("hey there...");
//	}
//	
//	@Test(priority = 0)
//	public void modifyCity() {
//		System.out.println("Smart Noida");	
//	}
//	
//	@Test(priority = 1)
//	public void deleteCity() {
//		System.out.println("Smart Noida");
//	}
	
//	DEPENDSONMETHODS
	
	@Test
	public void createCity() {
		System.out.println("Noida");
		Assert.assertTrue(false);
		System.out.println("hey there...");
	}
	

	@Test(dependsOnMethods = "createCity", alwaysRun = true)
//	@Test(dependsOnMethods = "createCity")
	public void modifyCity() {
		System.out.println("Smart Noida");	
	}
	
	@Test(dependsOnMethods = "modifyCity")
	public void deleteCity() {
		System.out.println("Smart Noida");
	}
	
}
