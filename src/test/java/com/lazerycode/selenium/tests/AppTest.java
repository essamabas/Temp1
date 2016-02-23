package com.lazerycode.selenium.tests;

import com.lazerycode.selenium.DriverFactory;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
// TestNG packages
import org.testng.annotations.*;
import static org.testng.Assert.*;
// selenium packages
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
// robot packages
import java.awt.*;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

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
    driver.get(baseUrl + "/pendulo/");
    
    // tell selenium to wait maximum 10 seconds for searching elements
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Thread.sleep(4000);
    //
    for ( String currentwindow : driver.getWindowHandles()) {
    	System.out.println("CurrentWindow>:" + currentwindow);
    }
    //
    try {
        // Switch to JavaScript Alert window    	
        Robot robot = new Robot();
        // insert username: haw
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_W);        
        robot.keyPress(KeyEvent.VK_A);
        //
        robot.keyPress(KeyEvent.VK_TAB);//go to password feild
        Thread.sleep(1000);
        // insert password: Meshmesh90!
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_9);
        robot.keyPress(KeyEvent.VK_0);
        robot.keyPress(KeyEvent.VK_CAPS_LOCK);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_CAPS_LOCK);        
        robot.keyPress(KeyEvent.VK_ENTER);
        // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);        
        // Release Enter
        robot.keyRelease(KeyEvent.VK_ENTER);        

        } catch (AWTException e) {
        e.printStackTrace();
        }    
    
/*    try{
    	//driver.switchTo().frame("Authentication Required");
        // get currentwindow
    	String currentWindow = driver.getWindowHandle();
    	// Switch to JavaScript Alert window
        Alert myAlert = driver.switchTo().alert();
        System.out.println("Alert text is " + myAlert.getText());
        driver.findElement(By.id("userId")).clear();
        driver.findElement(By.id("userId")).sendKeys("haw");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("Meshmesh90!");
        // switch to frame and do stuff..
        driver.switchTo().window(currentWindow); // switch back            
    } catch (NoAlertPresentException e) {
    //} catch (NoSuchFrameException e) {
    	//
    	System.err.println("NoAlertPresentException: " + e.getMessage());
    }*/

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
