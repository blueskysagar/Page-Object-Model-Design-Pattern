package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//span[normalize-space()='Log In']")
	WebElement loginBtn1;
	
	@FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement loginBtn;
	
	
	@FindBy(xpath = "//a[normalize-space()='Sign Up']")
	WebElement signupBtn;
	
	@FindBy(xpath = "//div[@class='rd-navbar-brand']//span[@class='brand-slogan'][normalize-space()='your business cloud partner']")
	WebElement crmLogo;
	// Page factory object initialization
	
	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	// Actions :
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateCrmImage() {
		return crmLogo.isDisplayed();
	}
	
	
	
	public HomePage login(String eml, String pw) throws IOException, InterruptedException {
		loginBtn1.click();
		Thread.sleep(2000);
		email.sendKeys(eml);
		password.sendKeys(pw);
		loginBtn.click();
		Thread.sleep(3000);
		
		return new HomePage();
	}
	

	
}
