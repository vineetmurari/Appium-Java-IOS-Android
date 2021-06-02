package com.myAndroid.Tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class FourthTest {
  @Test
  public void f() throws MalformedURLException, InterruptedException {
	  AndroidDriver<AndroidElement>  driver;
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
			
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.VERSION, "5.0.4"); 
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator123");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Dell\\Desktop\\Tutorials\\Mobile Test Apps\\ApiDemos-debug.apk");
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		
			
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		   
		Thread.sleep(2000);
		
		
		AndroidElement Views = driver.findElementByAccessibilityId("Views");
		Views.click();

		//Scroll Until Text is Found - Vertical scroll
				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().scrollIntoView(new UiSelector().text(\"Tabs\"));");
				 
				AndroidElement Tabs = driver.findElementByAccessibilityId("Tabs");
				Tabs.click();
				
				AndroidElement Scrollable = driver.findElementByAccessibilityId("5. Scrollable");
				Scrollable.click();
				
				AndroidElement ele3 =driver.findElement(MobileBy.AndroidUIAutomator
						("new UiSelector().text(\"TAB 1\")")); 
	
		try {
		    driver.findElement(MobileBy.AndroidUIAutomator(
		            "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollForward()"));
		} catch (InvalidSelectorException e) {
		    // ignore
		}
		
	
		
		driver.quit();
		
		driver.findElement(By.id("")).sendKeys("text");
		
		driver.navigate().back();
		
		driver.findElement(By.id("")).getText();
		
		String name =driver.findElement(By.id("name")).getAttribute("label");
		
		driver.findElement(By.id("name")).clear();
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);


		
		
		
		Thread.sleep(2000);
			
  }
}



