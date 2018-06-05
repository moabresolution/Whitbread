package com.whitbread.assignment.amazon.bdd_tests;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonProductTestStep {
	public static WebDriver driver;	
	
	@Given("I navigated to amazon.co.uk")
	public void i_navigated_to_amazon_co_uk() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\browsers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.co.uk/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("I search the {string}")
	public void i_search_the(String item) {
		item = "sony camera";
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(item);
		driver.findElement(By.className("nav-input")).click();
	}

	@When("I selected added second item on the list")
	public void i_selected_added_second_item_on_the_list() {
		driver.findElement(By.id("result_1")).click();		
	}

	@When("I click on cart")
	public void i_click_on_cart() {
		driver.findElement(By.name("submit.add-to-cart")).click();
	}

	@Then("I verify Item added")
	public void i_verify_Item_added() {
		driver.findElement(By.cssSelector("#nav-cart")).click();
		
		String subtotal = driver.findElement(By.cssSelector("#sc-subtotal-label-activecart")).getText();
		String basketItem = driver.findElement(By.cssSelector(".sc-product-title")).getText();
		
		String[] plitSubtotal = subtotal.split(":");
		
		System.out.println(plitSubtotal[0] + " AND the price is : " + plitSubtotal[1]);
		System.out.println("Basket Item Description : " + basketItem);
		assertTrue("Basket Item does not relate to Camera",basketItem.contains("Camera"));
	}
	
	@After
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}

}
