package com.crm.qa.pages;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(name = "last_name")
	WebElement lastName;
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name = "category")
	WebElement catgry;
	
	
	
	
	@FindBy(css = "button[class='ui linkedin button']")
	WebElement saveBtn;
	
	
	
	

	public ContactsPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
public boolean verifyContactsLabel() {
	return contactsLabel.isDisplayed();
	
}
public void selectContactsByName(String name) {

	//click on checkbox
	
	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td")).click();

	}

public void createNewContact(String ltName, String ftName, String catgrory) {
	
	
	lastName.sendKeys(ltName);
	System.out.println("last name entered as"+ltName);
	firstName.sendKeys(ftName);
	System.out.println("last name entered as"+ftName);
	catgry.click();
	driver.findElement(By.xpath("//div[@name='category']//div[@role='option']//span[text()='"+catgrory+"']")).click();
	
	//Select select = new Select(driver.findElement(By.xpath("\"//label[text()='Cateogry']/following-sibling::div[@class ='ui selection dropdown']")));
	//select.selectByVisibleText(catgry);
	saveBtn.click();
}
}
