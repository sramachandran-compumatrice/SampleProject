package com.EDR_Automation;

import org.testng.annotations.Test;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class EDR_Functionality 
{
	public WebDriver driver;
	public String baseURL = "https://parcelplatform.com/reporting/login.php";
	 
  @Test(description = "EDR_Login")//enabled=false)
  public void A_login() throws Exception
  {
	  /*System.setProperty("webdriver.ie.driver", "C:\\Users\\Jaycompumatrice\\Desktop\\Selenium\\library\\IEDriverServer.exe");
	  driver = new InternetExplorerDriver();*/
	  driver = new FirefoxDriver();
	  
	  driver.navigate().to(baseURL);
	  driver.manage().window().maximize();
	  Thread.sleep(9000);
	  driver.findElement(By.id("uEmail")).clear();
	  driver.findElement(By.id("uEmail")).sendKeys("JDevabakthuni");
	  driver.findElement(By.id("pass")).clear();
	  driver.findElement(By.id("pass")).sendKeys("Asdfghjkl_45");
	  driver.findElement(By.name("submit")).click();
	  
	  
  }
  @Test(description = "EDR_Logout",enabled=false)
  public void logout() throws Exception
  {
	  A_login();
	  Thread.sleep(9000);
	  driver.findElement(By.xpath("//*[@id='link_164']")).click();
	  driver.findElement(By.xpath("//*[@id='JayDevabakthuniMenu']/li/ul/li[4]/a")).click();
	
  }
  @Test(description = "ProjectStartMenu")
  public void Project_Start_Menu() throws Exception
  {
	  String start = driver.findElement(By.id("start-panel")).getText();
	  System.out.println(start);
	  Assert.assertEquals("Start", start,"Testcase pass");
	  //webdriverbackedselenium
	 Selenium sel=new WebDriverBackedSelenium(driver, baseURL);
	 if(sel.isElementPresent("start-panel"))
	 {
		 System.out.println("Start object is available");
	 }
	 else
	 {
		 System.out.println("Start object is  not available");
	 }
  }

}
