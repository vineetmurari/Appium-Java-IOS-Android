package com.myAndroid.Tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ThirdTest {
	
	
  @SuppressWarnings("deprecation")
@Test
  public void f() throws Exception {

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
		ele3.click();	
		
		//Scroll Until Text is Found - Horizontal scroll
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView(new UiSelector().text(\"TAB 8\"));");
		
		AndroidElement ele4 =driver.findElement(MobileBy.AndroidUIAutomator
				("new UiSelector().text(\"TAB 8\")")); 
		ele4.click();
		
  }
}
