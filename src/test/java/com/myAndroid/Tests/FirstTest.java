package com.myAndroid.Tests;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class FirstTest {
	
@BeforeTest
public void beforeTest() {
	  
}

@AfterTest
public void afterTest() {
	
  }	


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
	   
	Thread.sleep(10000);
	
	AndroidElement ele =driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']"));
	
	try{
	if(ele.isDisplayed()){
		System.out.println("PASS");
	}
	}
	catch(Exception e){
		System.out.println("FAIL");
	}
	
//	AndroidElement Acc = driver.findElement(By.id("android:id/text1"));
//	Acc.click();
	
//	AndroidElement graphic = driver.findElementByAccessibilityId("Graphics");
//	graphic.click();
//	
//	

List<AndroidElement> list = driver.findElements(By.className("android.widget.TextView"));
	
	for(AndroidElement e :list){
		System.out.println(e.getText());
	}
	
	//UIselector - Android
	
	AndroidElement ele2 =driver.findElement(MobileBy.AndroidUIAutomator
			("new UiSelector().text(\"App\").index(3).enabled(true)"));
	
	ele2.click();
	  
	//.index(2) checked(true) description
	
	
	
  }

}

//@BeforeMethod
//public void beforeMethod() {
//}
//
//@AfterMethod
//public void afterMethod() {
//}

//@BeforeClass
//public void beforeClass() {
//}
//
//@AfterClass
//public void afterClass() {
//}


//@BeforeSuite
//public void beforeSuite() {
//}
//
//@AfterSuite
//public void afterSuite() {
//}