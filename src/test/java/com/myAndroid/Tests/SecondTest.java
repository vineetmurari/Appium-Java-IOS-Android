package com.myAndroid.Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class SecondTest {
  @Test
  public void f() throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement>  driver;
			
		DesiredCapabilities capabilities = new DesiredCapabilities();
			
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.0.4"); 
		capabilities.setCapability("deviceName","Emulator123");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	 
			
			capabilities.setCapability("appPackage", "com.android.calculator2");
			capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
			
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		   
		Thread.sleep(10000);
		
		AndroidElement dig7 = driver.findElement(By.id("com.android.calculator2:id/digit_7"));
		AndroidElement dig3 = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
		AndroidElement sub = driver.findElement(By.id("com.android.calculator2:id/op_sub"));
		AndroidElement eq = driver.findElement(By.id("com.android.calculator2:id/eq"));
		
		dig7.click();
		sub.click();
		dig3.click();
		eq.click();
		
		
  }
}
