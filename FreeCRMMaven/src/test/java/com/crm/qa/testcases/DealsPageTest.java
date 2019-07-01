package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealPage;
	ContactsPage contactsPage;
	
	 String sheetName="Deals";
	
	public  DealsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		intialization();
		testUtil = new TestUtil();
		dealPage = new DealsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		testUtil.switchToFrame();
		//dealPage = homePage.clickonDealsLink();
		
		
	}

	@DataProvider
	public Object[][] getCRMTestData1()
	{
		System.out.println("in getCRMTestData1");
		Object data[][]=TestUtil.getTestData(sheetName);
		System.out.println("in getCRMTestData11");
		return data;
	}
	@Test(priority=1,dataProvider="getCRMTestData1")
	public void validatecreateNewDeal(String title,String pcontact,String amnt)
	{
		homePage.clickOnNewDealLink();
		//dealPage.createNewDeal("g", "test", "test", "10");
		
		//dealPage.createNewDeal(title, compname, pcontact,amnt);
		dealPage.createNewDeal(title, pcontact,amnt);
	}
	/*@Test(priority=1)
	public void validatecreateNewDeal(String title,String compname,String pcontact,String amount)
	{
		homePage.clickOnNewDealLink();
		dealPage.createNewDeal("g", "test", "test", "10");
		
		
	}*/
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
