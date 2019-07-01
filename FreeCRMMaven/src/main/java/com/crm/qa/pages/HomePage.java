package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: hdjsak dsad')]")
	WebElement UserNameLabel;

	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;

	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement newDeal;
	
	//Initializing the Page Objects:
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	public boolean verifyCorrectUserName()
	{
		return UserNameLabel.isDisplayed();
	}
	public ContactsPage clickonContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickonDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	public TaskPage clickonTaskLink()
	{
		tasksLink.click();
		return new TaskPage();
	}
	public void clickOnNewContactLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContact.click();
	}
	
	public void clickOnNewDealLink()//new deal link visible to do mouse hover=used action for mouse hover
	{
		Actions action=new Actions(driver);
		action.moveToElement(dealsLink).build().perform();
		newDeal.click();
	}
}
