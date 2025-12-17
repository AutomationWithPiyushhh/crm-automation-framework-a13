package configurationAnn;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base_utility.BaseClass;

public class SauceDemo extends BaseClass {

//	opening browser
//	login

	@Test
	public void addToCart() throws InterruptedException {
		Thread.sleep(3000);
//		add to cart
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();

//		verify
		boolean status = driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).isDisplayed();
		if (status) {
			System.out.println("successfully added to the cart");
		}
	}

//	logout
//	login

	@Test
	public void removetFromCart() throws InterruptedException {

		Thread.sleep(3000);
//		remove from cart
		driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();

//		verify
		boolean status = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).isDisplayed();
		if (status) {
			System.out.println("successfully removed from the cart");
		}
	}

//	logout
//	close the browser

}