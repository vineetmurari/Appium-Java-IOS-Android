package com.myAndroid.Tests;

import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class EightTest {
  @Test
  public void f() throws Exception{
	  

		AndroidDriver<AndroidElement>  driver;
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability(MobileCapabilityType.VERSION, "5.0.4"); 
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator123");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Dell\\Desktop\\Tutorials\\Mobile Test Apps\\ApiDemos-debug.apk");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
	
		
	driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	   
	Thread.sleep(2000);
	
	
	
	Set<String> set = driver.getContextHandles();
	
	// Switching to webview
	Set<String> contextNames = driver.getContextHandles();
	for (String contextName : contextNames) {
		System.out.println(contextNames); //prints out something like [NATIVE_APP, WEBVIEW_<APP_PKG_NAME>]
	}
	driver.context(contextNames.toArray()[1].toString()); // set context to WEBVIEW_<APP_PKG_NAME>
	
	driver.get("https://www.google.com");
	
	Thread.sleep(2000);
	
	driver.close();
	driver.quit();
	
	////SELENIUM 
  }
}
