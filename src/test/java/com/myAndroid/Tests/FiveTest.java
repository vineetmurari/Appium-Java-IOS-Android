package com.myAndroid.Tests;

import java.net.MalformedURLException;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class FiveTest {
  @SuppressWarnings("deprecation")
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
		
		TouchAction action = new TouchAction(driver);
		
		
		AndroidElement Anim = driver.findElementByAccessibilityId("Animation");
		
		action.tap(TapOptions.tapOptions().withElement(ElementOption.element(Anim))).perform();
		
		AndroidElement Seeking = driver.findElementByAccessibilityId("Seeking");
		
		action.tap(PointOption.point(Seeking.getLocation().x+2, Seeking.getLocation().y+2)).perform();
		
		AndroidElement seekbar = driver.findElement(By.id("io.appium.android.apis:id/seekBar"));
	
		int Start_X = seekbar.getLocation().getX();
		int Start_Y = seekbar.getLocation().getY();
		int width = seekbar.getSize().getWidth();
		
		System.out.println("X "+Start_X+" Y "+Start_Y+" width "+width);
		
		
		
		/// Handle seek bar
		
		action.longPress(LongPressOptions.longPressOptions()
		.withPosition(PointOption.point(Start_X, Start_Y))
		.withDuration(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(width, Start_Y)).release().perform();
		
		
	
		
		
		
		
		
		Thread.sleep(2000);
		
  }
}
