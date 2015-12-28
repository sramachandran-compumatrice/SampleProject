package com.EDR_Automation;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.Test;

	public class EDR_Login
	{
		public WebDriver driver;
		public String baseURL = "https://www.web.edrnet.com/ordering/switchboard/login.aspx";
		
	 
		@Test
		  public void login() throws Exception
		  {
			   driver = new FirefoxDriver();
			   
			  /*System.setProperty("webdriver.chrome.driver", "C:\\Users\\Desktop\\Selenium\\Seena_Selenium\\LIB\\chromedriver.exe");
			  driver = new ChromeDriver();*/
			   driver.navigate().to(baseURL);
			   driver.manage().window().maximize();
			   
			   driver.findElement(By.id("_Username")).sendKeys("2013212");
			   driver.findElement(By.id("_Password")).sendKeys("edrtest1");
			   driver.findElement(By.id("ctl00__ContentPlaceHolder__LoginUser")).click();
			   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   //Address
			   driver.findElement(By.id("Address_TXT")).sendKeys("guntur");//guntur//8004 case drive
			   driver.findElement(By.id("City_TXT")).sendKeys("Plano");
			   new Select(driver.findElement(By.id("State_DDL"))).selectByVisibleText("Texas");
			   driver.findElement(By.id("ZipCode_TXT")).sendKeys("75025");
			   driver.findElement(By.id("ctl00_ctl00_cphBody_cphMainContent_ibtContinue")).click();
			   Thread.sleep(3000);
			 
			   try 
			   {
				   if(driver.findElement(By.cssSelector("img[src*='/Global/images/EDRGoogleMap/tpstar.png']")).isDisplayed())
				   {  
					   System.out.println("Given details are correct, Please find the Green colour STAR mark");
				   }
			   }
			   catch (Exception e)
			   {
				    if(driver.findElement(By.className("modal-title")).isDisplayed())
					{
						   System.err.println("Alert was present,: Given details are wrong, Please enter valid address");
					}
			  }
		 	}
			@AfterTest
			public void afterTest() 
			{
				driver.quit();
			}

	}



