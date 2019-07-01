package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{
	
	@FindBy(id="title")
	WebElement title;
	/*
	@FindBy(xpath="//input[@type='text' and @name='client_lookup']")
	WebElement company;
	*/
	
	@FindBy(xpath="//input[@type='button' and @value='Lookup']")
	WebElement Lookup;
	
	@FindBy(xpath="//input[@type='text' and @name='contact_lookup']")
	WebElement primaryContact;
	
	@FindBy(id="amount")
	WebElement amount;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
/*	public void createNewDeal(String tle, String comp,String pcontact,String amt)
	{
		
		title.sendKeys(tle);
		company.sendKeys(comp);
		primaryContact.sendKeys(pcontact);
//		CharSequence[] amount1 = new StringBuffer[10];
//		amount1[0]= amt;
		
		
		amount.sendKeys(amt);
		
		saveBtn.click();
	}*/
	public void createNewDeal(String tle,String pcontact,String amt)
	{
		
		title.sendKeys(tle);
		//company.sendKeys(comp);
		primaryContact.sendKeys(pcontact);
//		CharSequence[] amount1 = new StringBuffer[10];
//		amount1[0]= amt;
		
		Lookup.click();
		
		amount.sendKeys(amt);
		
		//saveBtn.click();
	}
}
