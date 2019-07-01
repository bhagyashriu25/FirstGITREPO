package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;
	public HomePageTest(){
		super();
	}
	//test cases should be separated -- independent with each other
		//before each test case -- launch the browser and login
		//@test -- execute test case
		//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp()throws Exception
	{
		intialization();
		testUtil= new TestUtil();
		loginPage=new LoginPage();
		contactPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String title=homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","Home page title not match");
	}
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	
	}
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{

		testUtil.switchToFrame();
		contactPage= homePage.clickonContactsLink();
		
	
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	
	
}
