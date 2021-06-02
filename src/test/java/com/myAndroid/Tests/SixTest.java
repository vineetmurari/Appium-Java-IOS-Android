package com.myAndroid.Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SixTest {
  @Test
  public void f() throws InterruptedException, MalformedURLException {
	  
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
		
				  @SuppressWarnings("rawtypes")
				 
				    int pressX = driver.manage().window().getSize().width / 2;
				    
				    int bottomY = driver.manage().window().getSize().height * 4/5;
				   
				    int topY = driver.manage().window().getSize().height / 8;
				    
				    @SuppressWarnings("rawtypes")
					TouchAction touchAction = new TouchAction(driver);
				    touchAction.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(pressX, bottomY))).moveTo(PointOption.point(pressX, topY)).release().perform();
			  
			  
	  
  }
  }
  
