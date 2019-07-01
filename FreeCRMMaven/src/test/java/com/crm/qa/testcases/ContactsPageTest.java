package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
		
	 String sheetName="Contacts";
	 
	public ContactsPageTest(){
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() throws Exception {
		
		intialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		testUtil.switchToFrame();
		contactsPage = homePage.clickonContactsLink();
	}
	/*
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	@Test(priority=2)
	public void selectAllContactsTest(){
		contactsPage.selectContactsByName();
		System.out.println("checked");

	}
	*/
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=1,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String fname,String lname,String comp)
	{
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "tom", "peter", "google");
		contactsPage.createNewContact(title, fname, lname, comp);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}


