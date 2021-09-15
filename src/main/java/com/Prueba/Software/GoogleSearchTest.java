package com.Prueba.Software;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	private WebDriver driver;	
		
	@Before
	public void setUp() {
		System.out.println("Prueba1");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println("Prueba2");
	}
	
	
	@Test 
	public void testGooglePage() {
		WebElement search = driver.findElement(By.name("q"));
		search.clear();
		search.sendKeys("Induccion a la calidad de software");
		search.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("Induccion a la calidad de software - Buscar con Google", driver.getTitle());
	}
	 
	
	@After
	public void tearDown() {
		driver.quit();
		
	}
		
}
