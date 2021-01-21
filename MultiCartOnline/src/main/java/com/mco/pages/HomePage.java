package com.mco.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mco.base.TestBase;
 
public class HomePage  extends TestBase{
 
	// PAGE FACTORY OBJECT'S REPOSITORY
  
	@FindBy(xpath="//button[@id='dLabellogin']")
	WebElement login_Source_Button;
	
	@FindBy(linkText ="About Us")
	WebElement about_Us_Link;
	
	@FindBy(linkText ="Contact Us")
	WebElement contact_Us_Link;
	
	@FindBy(linkText ="View Cart")
	WebElement View_Cart_Link;
	
	@FindBy(xpath="//select[@class='topsearch_fld']")
	WebElement currency_List;
 
	//PAGE FACTORY INITIALIZATION
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLoginSourstButton() {
		 System.out.println("Name Of the Button is : " +login_Source_Button.getText());
	 return login_Source_Button.isDisplayed();
 		
	}
	public boolean validateAbotUsLink() {
		 System.out.println("Name Of the Object is : " +about_Us_Link.getText());
	boolean validateAboutUs = about_Us_Link.isDisplayed();
		return validateAboutUs;
	}
	public boolean validateContactUsLink() {
		 System.out.println("Name Of the Object is : " +contact_Us_Link.getText());
		boolean validateContactUs = contact_Us_Link.isDisplayed();
			return validateContactUs;
		}
	public boolean validateViewCartLink() {
		 System.out.println("Name Of the Object is : " +View_Cart_Link.getText());
		boolean validateViewCart = View_Cart_Link.isDisplayed();
			return validateViewCart;
		}
	
	public String verifyCurrencyLists() {
		//Select select = new Select(driver.findElement(By.xpath("//select[@class='topsearch_fld']")));
	 
		Select select = new Select(currency_List);
		System.out.println("Available Currency Type is : ");
		for(int i = 0; i <=11; i++) {
			String allCurency = select.getOptions().get(i).getText();
			System.out.println(i+" "+allCurency);
		}
		return currency_List.getText();
	}
	
	
	
	
	
	
	
	
}
