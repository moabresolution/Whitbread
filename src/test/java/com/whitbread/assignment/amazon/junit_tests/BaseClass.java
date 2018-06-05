package com.whitbread.assignment.amazon.junit_tests;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


class BaseClass {
	protected static WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\browsers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.co.uk/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() throws Exception {		
		driver.quit();
	}

}
