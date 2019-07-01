package com.crm.qa.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Broser {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.firefox.marionette", "D:/Selenium/geckodriver.exe");
		//WebDriver driver= new FirefoxDriver();
		
		System.setProperty("webdriver.ie.driver","D:/Selenium/IEDriverServer.exe");
		WebDriver driver =new InternetExplorerDriver();
		Thread.sleep(100);
		driver.get("http://qaclickacademy.com/practice.php");
		
	}

}
