package com.whitbread.assignment.amazon.junit_tests;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

class AmazonProductTest extends BaseClass{		

	@Test
	void productSearchTest() throws InterruptedException {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sony camera");
		driver.findElement(By.className("nav-input")).click();
		driver.findElement(By.id("result_1")).click();
		driver.findElement(By.name("submit.add-to-cart")).click();
		
		driver.findElement(By.cssSelector("#nav-cart")).click();
		
		String subtotal = driver.findElement(By.cssSelector("#sc-subtotal-label-activecart")).getText();
		String basketItem = driver.findElement(By.cssSelector(".sc-product-title")).getText();
		
		String[] plitSubtotal = subtotal.split(":");
		
		System.out.println(plitSubtotal[0] + " AND the price is : " + plitSubtotal[1]);
		System.out.println("Basket Item Description : " + basketItem);
		assertTrue("Basket Item does not relate to Camera",basketItem.contains("Camera"));
	}
	
}

