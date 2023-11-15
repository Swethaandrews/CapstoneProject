package com.sportyshoe.SeleniumTestNGScripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class SetupCheck {
	
	@Test
	public void setup_check_SportyShoes()  {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:9010/");
        String text = driver.findElement(By.xpath("//div[@class='container mt-3']/descendant::p[1]")).getText();
		System.out.println(text);
	    System.out.println(driver.getTitle());		
}
}
