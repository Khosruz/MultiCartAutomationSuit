package com.mco.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mco.base.TestBase;
import com.mco.pages.HomePage;
import com.mco.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	static LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}


	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();

	}

	@Test
	public void loginPageTitleTest() {
		loginPage.validatePageTitle();
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "WildFire Cart", "Title of is 'WildFire Cart' not Available!!");
	}

	@Test
	public void loginLogoImageTest() {
		boolean flag = loginPage.validateLoginLogoImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 1)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));

	}

	@Test(priority = 2)
	public void curentUserNameTest() {
		LoginPageTest.loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.validatCurentUserName();

	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
