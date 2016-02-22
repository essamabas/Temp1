package com.lazerycode.selenium.tests;

import com.lazerycode.selenium.DriverFactory;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class AppTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  // Set Chrome in PATH
	 System.setProperty("webdriver.chrome.driver", 
			  "D://EclipseWS//maven-template//selenium_standalone//windows//googlechrome//32bit//chromedriver.exe");
	driver = new ChromeDriver();
    baseUrl = "https://tb.itgain.de/";
    
    //String currentWindow = driver.getWindowHandle();
    // Switch to Authentication /Required Frame
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //
    for ( String currentwindow : driver.getWindowHandles()) {
    	System.out.println("CurrentWindow>:" + currentwindow);
    }
    //
    
    try{
    	driver.switchTo().frame("Authentication Required");
    } catch (NoSuchFrameException e) {
    	//
    	System.err.println("IndexOutOfBoundsException: " + e.getMessage());
    }
    
    
    driver.findElement(By.id("userId")).clear();
    driver.findElement(By.id("userId")).sendKeys("haw");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("Meshmesh90!");    
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    // switch to frame and do stuff..
    //driver.switchTo().window(currentWindow); // switch back    
  }

  @Test
  public void testTc2() throws Exception {
    driver.get(baseUrl + "/pendulo/");
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | mainFrame | ]]
    driver.findElement(By.name("Submit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=naviFrame | ]]
    driver.findElement(By.cssSelector("nobr")).click();
    driver.findElement(By.cssSelector("nobr")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=mainFrame | ]]
    driver.findElement(By.id("RowCol2_0")).clear();
    driver.findElement(By.id("RowCol2_0")).sendKeys("9");
    driver.findElement(By.id("RowCol2_0")).clear();
    driver.findElement(By.id("RowCol2_0")).sendKeys("9");
    driver.findElement(By.id("saveButt")).click();
    driver.findElement(By.id("saveButt")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
