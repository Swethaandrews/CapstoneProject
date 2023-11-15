package com.sportyshoe.Tests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.sportyshoe.SeleniumTestNGScripts.Homepage;
import com.sportyshoe.SeleniumTestNGScripts.LoginPage;
import com.sportyshoe.SeleniumTestNGScripts.RegisterPage;
import com.sportyshoe.SeleniumTestNGScripts.TestBase;
import com.sportyshoe.SeleniumTestNGScripts.AddtoCartPage;


public class AddtoCartPageTest extends TestBase{
	Homepage hp;
	RegisterPage rp;
	LoginPage lp;
	AddtoCartPage ac;
	
	@BeforeTest
	public void start_browser()
	{
		OpenBrowser("Chrome");
		hp = new Homepage(driver);
		rp = new RegisterPage(driver);
		lp = new LoginPage(driver);
		ac = new AddtoCartPage(driver);
	}
	
	@Test(priority='1')
	public void test_login()
	{
		lp.user_login();
	}
	

	@Test(priority='2')
	public void test_add_product_to_cart() throws InterruptedException
	{
		ac.add_product_to_cart();
	}
	
	@Test(priority='3')
	public void test_validate_success_message()
	{
		String expected = "Message:Shoe BlueWave Running Shoes Added Successfully to Cart";
	String actualText=	ac.validate_success_message();
	Assert.assertEquals(actualText, expected);
	}
}

